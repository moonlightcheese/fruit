package com.moonlightcheese.storage.database;

/**
 * Created with IntelliJ IDEA.
 * User: jarrod
 * Date: 6/7/14
 * Time: 10:16 PM
 */
public class ColumnType {
    private int   m_Type;   /** this variable is a value of the class {@link java.sql.Types} **/

    public ColumnType(int type) {
        m_Type = type;
    }

    public final int getType() {
        return m_Type;
    }
}
