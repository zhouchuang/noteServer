package user.zc.service;

import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.service.Service;
import user.zc.model.Note;

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
    public List<Note> queryNoteList(){
        List<Note> list = new ArrayList<Note>();
        Note note = new Note();
        note.setId(UUID.randomUUID().toString());
        note.setCreateTime(new Date());
        note.setTitle("Java");
        note.setContent("一切皆是对象");
        note.setStar(true);
        list.add(note);

        Note note1 = new Note();
        note1.setId(UUID.randomUUID().toString());
        note1.setCreateTime(new Date());
        note1.setTitle("Python");
        note1.setContent("不要重复造轮子");
        note1.setStar(false);
        list.add(note1);

        return list;
    }
}
