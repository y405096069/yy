package test;/**
 * @author caisheng
 * @create 2019-11-13 12:31
 */

import com.nfdw.Application;
import com.nfdw.entity.*;
import com.nfdw.mapper.AdministratoraccountMapper;
import com.nfdw.mapper.DataManageMapper;
import com.nfdw.pojo.Condition;
import com.nfdw.pojo.Examination;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author caisheng
 * @create 2019-11-13 12:31
 */


@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)// 就是你springboot的启动类
public class mapperTest {
    @Autowired
    AdministratoraccountMapper administratoraccountMapper;

    @Test
    public void test() {
        Examination examination = new Examination();

        List<Examinationstatistics> examinationstatistics = administratoraccountMapper.Examinationstatisticsimpl();
        System.out.println(examinationstatistics);
    }




}
