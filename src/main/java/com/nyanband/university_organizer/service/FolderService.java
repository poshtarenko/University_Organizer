package com.nyanband.university_organizer.service;

import com.nyanband.university_organizer.dto.FolderDto;
import com.nyanband.university_organizer.dto.SaveFolderDto;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;

@Validated
public interface FolderService {

    List<FolderDto> getDisciplineFolders(long disciplineId);

    boolean isFolderBelongsToUser(long folderId, long userId);

    FolderDto save(@Valid SaveFolderDto semesterDto);

    void delete(long folderId);
}
