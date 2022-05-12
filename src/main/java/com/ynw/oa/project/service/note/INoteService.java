package com.ynw.oa.project.service.note;

import com.ynw.oa.project.po.Note;

import java.util.List;

/**
 * @author 俞能武
 */
public interface INoteService{
    int deleteByPrimaryKeys(Integer[] id);

    int insertSelective(Note record);

    Note selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Note record);

    List<Note> selectNoteList(Note note);
}
