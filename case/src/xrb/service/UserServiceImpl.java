package xrb.service;

import xrb.dao.UserDao;
import xrb.dao.UserDaoImpl;
import xrb.entry.PageBean;
import xrb.entry.User;

import java.util.List;
import java.util.Map;

/**
 * @author xieren8iao
 * @create 2019/3/20 - 17:40
 */
public class UserServiceImpl implements UserService {
    private UserDao dao = new UserDaoImpl();

    @Override
    public List<User> findAll() {
        return dao.findAll();
    }

    @Override
    public User login(User user) {
        return dao.findUserByUsernameAndPassword(user.getUsername(), user.getPassword());
    }

    @Override
    public void addUser(User user) {
        dao.add(user);
    }

    @Override
    public void deleteUser(String id) {
        dao.delete(Integer.parseInt(id));
    }

    @Override
    public User findUserById(String id) {
        return dao.findUserById(Integer.parseInt(id));
    }

    @Override
    public void updateUser(User user) {
        dao.update(user);
    }

    /*批量删除用户*/
    @Override
    public void delSelectedUser(String[] ids) {
        if (ids != null && ids.length > 0) {
            for (String id : ids) {
                dao.delete(Integer.parseInt(id));
            }
        }
    }

    @Override
    public PageBean<User> findUserByPage(String _currentPage, String _rows, Map<String, String[]> condiction) {
        //创建PageBean对象
        PageBean<User> pb = new PageBean<User>();
        int currentPage = Integer.parseInt(_currentPage);
        //显示记录数
        int rows = Integer.parseInt(_rows);
        //总记录数
        int totalCount = dao.findTotalCount(condiction);
        //计算总页码
        int totalPage = (totalCount % rows == 0)
                ? totalCount / rows : (totalCount / rows) + 1;
        //计算开始的索引
        int start = (currentPage - 1) * rows;
        if (currentPage <= 0) {
            currentPage = 1;
        }
        if (currentPage > totalPage) {
            currentPage = totalPage;
        }
        List<User> list = dao.findByPage(start, rows,condiction);
        //将所有数据封装成pageBean对象
        pb.setCurrentPage(currentPage);
        pb.setRows(rows);
        pb.setTotalCount(totalCount);
        pb.setList(list);
        pb.setTotalPages(totalPage);
        return pb;
    }
}
