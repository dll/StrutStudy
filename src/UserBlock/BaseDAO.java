package UserBlock;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Richard on 2017/6/16.
 */
public interface BaseDAO {

    public boolean insert(User Add) throws  Exception;

    public Collection select() throws  Exception;

    public boolean delete(User Add) throws  Exception;

    public ArrayList up_select(User Add) throws  Exception;

    public boolean update(User Add) throws  Exception;
}
