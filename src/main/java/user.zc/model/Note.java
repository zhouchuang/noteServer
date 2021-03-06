package user.zc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @description：笔记实体类
 * @author：zhouchuang
 * @date：2017-11-15:14
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Note extends BaseModel {
        private String title;
        private String author;
        private String content;
        private Boolean star;
        private Date time;
        private long version;
}
