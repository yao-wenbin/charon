package io.github.yaowenbin.server.monitor;

import lombok.Data;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Collection;
import java.util.Date;

/**
 * @Author yaowenbin
 * @Date 2023/8/24
 */
@Mapper
public interface TestMapper {

    @Select("select * from test")
    Collection<Test> selectAll();

}

@Data
class Test {

    private Long id;

    private String title;

    private Date createTime;

}
