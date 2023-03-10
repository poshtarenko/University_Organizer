package com.nyanband.university_organizer.controller;

import com.nyanband.university_organizer.controller.util.ControllerUtils;
import com.nyanband.university_organizer.dto.FolderDto;
import com.nyanband.university_organizer.dto.SaveFolderDto;
import com.nyanband.university_organizer.exception.AccessDeniedException;
import com.nyanband.university_organizer.service.DisciplineService;
import com.nyanband.university_organizer.service.FolderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/folders")
@CrossOrigin(origins = "*", maxAge = 3600)
@Api(description = "Folder API")
public class FolderController {

    DisciplineService disciplineService;
    FolderService folderService;

    @Autowired
    public FolderController(DisciplineService disciplineService, FolderService folderService) {
        this.disciplineService = disciplineService;
        this.folderService = folderService;
    }

    @GetMapping
    @ApiOperation("Get all folders by discipline id")
    public List<FolderDto> getDisciplineFolders(@RequestParam("disciplineId") Long disciplineId) {
        long userId = ControllerUtils.getUserId();
        if (disciplineService.isDisciplineBelongsToUser(disciplineId, userId)) {
            return folderService.getDisciplineFolders(disciplineId);
        } else {
            throw new AccessDeniedException("Discipline does not exist or user dont have access on it");
        }
    }

    @PostMapping
    @ApiOperation("Create new folder")
    public FolderDto addFolder(@RequestBody SaveFolderDto folderDto) {
        long userId = ControllerUtils.getUserId();
        long disciplineId = folderDto.getDisciplineId();
        if (disciplineService.isDisciplineBelongsToUser(disciplineId, userId)) {

            return folderService.save(folderDto);
        } else {
            throw new AccessDeniedException("Discipline does not exist or user dont have access on it");
        }
    }

    @PostMapping("/delete")
    @ApiOperation("Delete folder by id")
    public ResponseEntity<?> deleteDiscipline(@RequestParam("folderId") Long folderId) {
        long userId = ControllerUtils.getUserId();

        if (folderService.isFolderBelongsToUser(folderId, userId)) {
            folderService.delete(folderId);
            return ControllerUtils.okResponse();
        } else {
            throw new AccessDeniedException("Folder does not exist or user dont have access on it");
        }
    }

}
