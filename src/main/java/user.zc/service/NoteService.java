package user.zc.service;

import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.service.Service;
import user.zc.model.Note;
import user.zc.util.NoteException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @description：笔记数据层
 * @author：zhouchuang
 * @date：2017-11-15:12
 */
@IocBean
public class NoteService extends Service {
    private static List<Note> noteList;
    static {
        noteList = new ArrayList<Note>();
        Note note = new Note();
        note.setId(UUID.randomUUID().toString());
        note.setTime(new Date());
        note.setTitle("Java");
        note.setContent("一切皆是对象");
        note.setStar(true);
        noteList.add(note);

        Note note1 = new Note();
        note1.setId(UUID.randomUUID().toString());
        note1.setTime(new Date());
        note1.setTitle("Python");
        note1.setContent("不要重复造轮子");
        note1.setStar(false);
        noteList.add(note1);
    }
    public List<Note> queryNoteList(){
        return noteList;
    }
    public void synchronizationData(List<Note> newNoteList)throws Exception{
        for(Note note :newNoteList){
            for(Note oldNote:noteList){
                if(note.getId().equalsIgnoreCase(oldNote.getId())){
                    oldNote.setContent(note.getContent());
                    oldNote.setTitle(note.getTitle());
                    oldNote.setStar(note.getStar());
                    break;
                }
            }
        }
    }
    public void deleteNote(Note note)throws Exception{
        for(Note oldNote:noteList) {
            if (note.getId().equalsIgnoreCase(oldNote.getId())) {
                noteList.remove(oldNote);
                break;
            }
        }
    }
    public Note getNote()throws Exception{
        Note note = new Note();
        note.setId(UUID.randomUUID().toString());
        note.setTime(new Date());
        note.setTitle("标题");
        note.setContent("正文");
        note.setStar(true);
        noteList.add(note);
        return note;
    }
}
