package user.zc.model;

import lombok.Data;
import org.nutz.dao.entity.annotation.*;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

/**
 * @description：实体类基础类
 * @author：zhouchuang
 * @date：2017-11-15:15
 */
@Data
@PK("id")
public class BaseModel implements Serializable {

    public String uuid() {
        return UUID.randomUUID().toString();
    }


    @Prev(els = @EL("$me.uuid()"))
    private String id;
    /**
     * 创建人
     */
    @Column("createBy")
    @ColDefine(type = ColType.VARCHAR, width = 40)
    private String createBy;

    /**
     * 创建时间
     */
    @Column("createTime")
    private Date createTime;

    /**
     * 更新人
     */
    @Column("updateBy")
    @ColDefine(type = ColType.VARCHAR, width = 40)
    private String updateBy;

    /**
     * 更新时间
     */
    @Column("updateTime")
    private Date updateTime;

    /**
     * 创建人ID
     */
    @Prev(els = @EL("$me.loginUserId()"))
    @Column("createrId")
    @ColDefine(type = ColType.VARCHAR, width = 40)
    private String createrId;

}