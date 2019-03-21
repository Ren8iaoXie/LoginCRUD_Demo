package xrb.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import xrb.entry.User;
import xrb.util.JDBCUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author xieren8iao
 * @create 2019/3/20 - 17:41
 */
public class UserDaoImpl implements  UserDao {
    private JdbcTemplate  template= new JdbcTemplate(JDBCUtils.getDataSource());

    /*通过整个user对象返回list*/
    @Override
    public List<User> findAll() {
        String sql="select * from user";
        //返回信息并封装成user对象
        List<User> users = template.query(sql, new BeanPropertyRowMapper<User>(User.class));

        return users;
    }
    /*通过用户名和密码查询返回User对象*/
    @Override
    public User findUserByUsernameAndPassword(String username, String password) {
        try {
            String sql = "select * from user where username = ? and password = ?";
            User user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username, password);
            return user;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    /*添加用户*/
    @Override
    public void add(User user) {
        String sql="insert into user values(null,?,?,?,?,?,?,null,null)";
        template.update(sql,user.getName(),
                user.getGender(),user.getAge(),
                user.getAddress(),user.getQq(),user.getEmail()
        );
    }
    /*通过id删除信息*/
    @Override
    public void delete(int id) {
        String sql="delete from user where id=?";
        template.update(sql, id);
    }
    /*通过id返回对象*/
    @Override
    public User findUserById(int id) {
        String sql="select * from user where id="+id;
        User user=template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class));

        return user;
    }
    /*通过user更新*/
    @Override
    public void update(User user) {
        String sql="update user set name=?,gender=?,age=?,address=?,qq=?,email=? where id=?";
        template.update(sql, user.getName(),
                user.getGender(),user.getAge(),
                user.getAddress(),user.getQq(),user.getEmail(),user.getId());
    }

    @Override
    public int findTotalCount(Map<String, String[]> condiction) {
        //恒等式1=1
        String sql="select count(*) from user where 1=1 ";
        //拼接sql语句所用
        StringBuilder sb=new StringBuilder(sql);
        //添加查询的参数
        List<Object> list=new ArrayList<Object>();

        for (String key : condiction.keySet()) {
            if("currentPage".equals(key)||"rows".equals(key)){
                continue;
            }
            String value=condiction.get(key)[0];
            if(value!=null||"".equals(value)){

                sb.append(" and "+key+" like ? ");
                list.add("%"+value+"%");
            }
        }
        sql=sb.toString();
        return template.queryForObject(sql, Integer.class,list.toArray());
    }

    @Override
    public List<User> findByPage(int start, int rows, Map<String, String[]> condiction) {
        String sql="select * from user where 1=1 ";
        StringBuilder sb=new StringBuilder(sql);
        List<Object> list=new ArrayList<Object>();

        for (String key : condiction.keySet()) {
            if("currentPage".equals(key)||"rows".equals(key)){
                continue;
            }
            String value=condiction.get(key)[0];
            if(value!=null||"".equals(value)){
                sb.append(" and "+key+" like ? ");
                list.add("%"+value+"%");
            }
        }
        sb.append(" limit ?,? ");
        list.add(start);
        list.add(rows);
        //要记得把sb转成string类型的sql语句
        sql=sb.toString();
        //list.toArray()，将参数类型变成数组
        return  template.query(sql, new BeanPropertyRowMapper<User>(User.class),list.toArray());
    }


}
