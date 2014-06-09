package com.moonlightcheese.storage.database;

/**
 * Created with IntelliJ IDEA.
 * User: jarrod
 * Date: 6/8/14
 * Time: 12:05 AM
 * To change this template use File | Settings | File Templates.
 */
public interface AndroidTable {
    /**
     * The unique ID for a row.
     * <P>Type: INTEGER (long)</P>
     */
    public static final String _ID = "_id";

    /**
     * The count of rows in a directory.
     * <P>Type: INTEGER</P>
     */
    public static final String _COUNT = "_count";
}
