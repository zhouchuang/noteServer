package user.zc.controller;

import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Ok;
import user.zc.service.NoteService;

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
    public Object noteList() {
        return noteService.queryNoteList();
    }

}
