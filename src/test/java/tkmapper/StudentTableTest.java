package tkmapper;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lujieni.tkmapper.TkmapperApplication;
import com.lujieni.tkmapper.dao.StudentDao;
import com.lujieni.tkmapper.domain.dto.StudentDTO;
import com.lujieni.tkmapper.domain.po.StudentPO;
import com.lujieni.tkmapper.service.impl.StudentServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TkmapperApplication.class)
public class StudentTableTest {
    @Autowired
    private StudentServiceImpl studentServiceImpl;

    @Autowired
    private StudentDao studentDao;

    @Test
    public void save(){
        studentServiceImpl.save(new StudentPO().setName("范玮琪").setAge(34));
    }

    @Test
    public void searchByCriteriaOne(){
        Example example = new Example(StudentPO.class);
        Example.Criteria criteria = example.createCriteria();
        /*andEqualTo中的property字段必须是实体类的成员属性!!!*/
        criteria.andEqualTo("age",34);
        List<StudentPO> studentPOS = studentServiceImpl.selectByExample(example);
        System.out.println(studentPOS);
    }

    @Test
    public void searchByCriteriaTwo(){
        Example example = new Example(StudentPO.class);
        Example.Criteria criteria = example.createCriteria();
        /*andCondition中的condition是db表中的字段*/
        criteria.andCondition("age like","%4%");//也可以实现模糊查询
        //criteria.andLike("age", "%4%");//模糊查询必须加%,这里如果写成"4"则查不到任何数据
        List<StudentPO> studentPOS = studentServiceImpl.selectByExample(example);
        System.out.println(studentPOS);
    }


    @Test
    public void multiplexi(){
        Example example = new Example(StudentPO.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("age",23);
        List<StudentPO> studentPOS = studentServiceImpl.selectByExample(example);
        System.out.println(studentPOS);
        /*
         * 要想复用必须先清空example里的参数再重新创建criteria
         */
        example.clear();
        criteria = example.createCriteria();
        criteria.andEqualTo("name","范玮琪");
        studentPOS = studentServiceImpl.selectByExample(example);
        System.out.println(studentPOS);
    }


    @Test
    public void search2(){
        Example example = new Example(StudentPO.class);

        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id",1);
        /*
            其实用example.or();也可以达到效果
         */
        Example.Criteria criteria2 =  example.createCriteria();
        criteria2.andEqualTo("name","a").andEqualTo("age",1);
        example.or(criteria2);
        studentDao.selectByExample(example);
    }

    /**
     * 根据id批量更新gender字段
     */
    @Test
    public void updateGenderByIdInBatch(){
        studentDao.updateGenderByIdInBatch(Arrays.asList("1","2"),"哈2");
        //studentDao.updateGenderByIdInBatch(new ArrayList<>(),"哈2"); 这里的list的size为0的话代码会抛错
    }

    /**
     * 根据名字模糊查询
     */
    @Test
    public void searchByName(){
        studentDao.searchByName("王");
    }

    /**
     * 因为在application.yml中设置了
     * mapper:
     *     not-empty: true
     * 导致了""会被tkmapper认为是null从而updateByPrimaryKeySelective部分字段不更新
     */
    @Test
    public void updateSelective(){
        StudentPO po = new StudentPO();
        po.setId(1);
        po.setName("");
        po.setGender("哦1");
        studentDao.updateByPrimaryKeySelective(po);
    }


    /**
     * PageHelper.startPage默认会查询存在数据的条数,这个会影响
     * 到PageInfo对象中total和pages的参数的值。很简单,total是
     * 数据的总条数,pages是能分几页。
     */
    @Test
    public void selectByPage(){
        PageHelper.startPage(1,4);//默认就要先查询符合条数的数据的总个数
        List<StudentPO> studentPOS = studentServiceImpl.selectAll();//返回的实际类是:Page
        PageInfo pageInfo = new PageInfo(studentPOS);
        System.out.println(pageInfo);
    }

    @Test
    public void useResultMap(){
        List<StudentDTO> studentDTOS = studentDao.useResultMap();
        System.out.println(studentDTOS);
    }
    



}
