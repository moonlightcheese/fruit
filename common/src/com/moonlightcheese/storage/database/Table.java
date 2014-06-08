package com.moonlightcheese.storage.database;

import com.java.sql.ColumnTypes;
import com.moonlightcheese.storage.database.AndroidTable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: jarrod
 * Date: 6/7/14
 * Time: 9:19 PM
 *
 * this class is the basic structure of a table, which are defined in the schema definition.
 */
public abstract class Table implements AndroidTable {
    private String          TABLE_NAME;     //set by the subclass in the constructor.
    private String          CREATE_TABLE_STATEMENT;     //the statement used to create this table.

    private static final List<Column> m_Columns = new ArrayList<Column>();

    //the static singleton instance.  this will be inherited by subclasses of this class.
    protected static Table m_Instance;

    /**
     * @param tableName the database table name.
     */
    protected Table(String tableName, List<Column> columns) {
        TABLE_NAME = tableName;
        if(columns != null) {
            if(!m_Columns.isEmpty())
                m_Columns.clear();
            m_Columns.addAll(columns);
        } else {
            throw new IllegalStateException("the columns list was null.  this is a developer error.  please report to support.");
        }
    }

    /**
     * @deprecated
     * @return
     */
    private Table() {
        //empty constructor.  debug testing only.  don't use.
    }

    protected static Table getInstance() {
//        if(m_Instance == null)
//            m_Instance = <? extends Table>;
        return null;
    }

    public final String getTableName() {
        if(TABLE_NAME == null)
            throw new IllegalStateException("table names cannot be null.");
        return TABLE_NAME;
    }

    /**
     * this method builds the create table statement that we will use to create the table.
     * @return
     */
    public String getCreateTableStatement() {
        //TODO!: also need to check if some kind of significant change was made that would invalidate the cached statement.
        //we 'cache' the create table statement so we don't have to build it each time.
        StringBuffer createTableStatement = new StringBuffer();

        //begin the create table statement.
        createTableStatement.append("CREATE TABLE ");
        //insert the table name.
        createTableStatement.append(getTableName());
        //add required Android key
        createTableStatement.append(" (" + _ID + " " + ColumnTypes.INTEGER + " PRIMARY KEY AUTOINCREMENT");

        //now cycle through all columns and add to the statement.
        for(Column column : m_Columns) {
            //name of the column to add
            createTableStatement.append(", " + column.getColumnName() + " ");
            //loop through this column's types and apply them to the statement (ie. NOT NULL, INTEGER, etc...)
            for(ColumnType type : column.getColumnTypes()) {
                createTableStatement.append(type.getType());
                if(column.getColumnTypes().get(column.getColumnTypes().size()-1) == type)   //if this is the last type for this column
                    break;
                else
                    createTableStatement.append(" ");       //otherwise append whitespace to separate the next type.
            }
        }

        //finish up the statement
        createTableStatement.append(");");

        CREATE_TABLE_STATEMENT = createTableStatement.toString();

        return CREATE_TABLE_STATEMENT;
    }

    public final List<Column> getColumns() {
        return m_Columns;
    }
}
