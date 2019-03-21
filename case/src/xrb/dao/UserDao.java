package xrb.dao;

import xrb.entry.User;

import java.util.List;
import java.util.Map;

/**用户操作的dao
 * @author xieren8iao
 * @create 2019/3/20 - 17:40
 */
public interface UserDao {
    public List<User> findAll();

    public User findUserByUsernameAndPassword(String username, String password);

    public  void add(User user);

    public void delete(int id);

    public User findUserById(int id);

    public void update(User user);

    public int findTotalCount(Map<String, String[]> condiction);

    public List<User> findByPage(int start, int rows, Map<String, String[]> condiction);
}
