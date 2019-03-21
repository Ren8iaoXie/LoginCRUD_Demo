package xrb.service;

import xrb.entry.PageBean;
import xrb.entry.User;

import java.util.List;
import java.util.Map;

/**用户管理接口
 * @author xieren8iao
 * @create 2019/3/20 - 17:39
 */
public interface UserService {
    //查找功能
    public List<User> findAll();
    //登陆功能
    public User login(User user);
    //添加用户
    public void addUser(User user);
    //删除用户
    public void deleteUser(String id);
    //通过id查找用户信息
    public User findUserById(String id);
    //通过user对象更新信息
    public void updateUser(User user);
    //删除选中id的User信息
    public void delSelectedUser(String[] ids);
    //分页功能
    public PageBean<User> findUserByPage(String currentPage, String rows, Map<String, String[]> condiction);
}
