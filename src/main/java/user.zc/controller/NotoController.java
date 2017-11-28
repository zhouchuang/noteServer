package user.zc.controller;

import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.lang.util.NutMap;
import org.nutz.mvc.adaptor.JsonAdaptor;
import org.nutz.mvc.annotation.*;
import org.nutz.mvc.filter.CrossOriginFilter;
import user.zc.model.Note;
import user.zc.service.NoteService;
import user.zc.util.NoteException;

import javax.annotation.PreDestroy;
import java.util.List;

/**
 * @description：笔记数据控制层
 * @author：zhouchuang
 * @date：2017-11-15:10
 */
@IocBean
@At("/api/note")
public class NotoController {

    @Inject
    private NoteService noteService;


    @At
    @Ok("json")
    @Filters(@By(type=CrossOriginFilter.class))
    public List<Note> noteList(@Param("name") String name) {
        return noteService.queryNoteList();
    }

    @At
    @Ok("json")
    @AdaptBy(type = JsonAdaptor.class)
    @Filters(@By(type=CrossOriginFilter.class))
    public NutMap  synchronizationData( @Param("..") List<Note> noteList){
        NutMap result = new NutMap();
        try {
            noteService.synchronizationData(noteList);
            result.addv("noteList",noteService.queryNoteList());
            result.setv("ok",true);
            result.setv("msg","同步数据成功");
            return result;
        }catch (Exception e){
            e.printStackTrace();
            result.setv("ok",false);
            result.setv("msg","同步数据失败");
            return result;
        }

    }

    @At
    @Ok("json")
    @Filters(@By(type=CrossOriginFilter.class))
    public Note getNote() {
        try {
            return noteService.getNote();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @At
    @Ok("json")
    @AdaptBy(type = JsonAdaptor.class)
    @Filters(@By(type=CrossOriginFilter.class))
    public NutMap  deleteNote(@Param("..") Note note){
        NutMap result = new NutMap();
        try {
            noteService.deleteNote(note);
            result.setv("ok",true);
            result.setv("msg","删除成功");
            return result;
        }catch (Exception e){
            e.printStackTrace();
            result.setv("ok",false);
            result.setv("msg","删除失败");
            return result;
        }
    }

}
