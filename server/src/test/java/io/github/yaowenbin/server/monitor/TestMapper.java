package io.github.yaowenbin.server.monitor;

import com.mybatisflex.core.BaseMapper;
import lombok.Data;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;

/**
 * @Author yaowenbin
 * @Date 2023/8/24
 */
@Mapper
public interface TestMapper extends BaseMapper<Test> {

}

@Data
class Test {

    private Long id;

    private String title;

    private Date createTime;

}
