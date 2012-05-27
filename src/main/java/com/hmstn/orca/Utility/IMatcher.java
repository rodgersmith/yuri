package com.hmstn.orca.Utility;

/**
 * Created with IntelliJ IDEA.
 * User: rodsmith
 * Date: 5/24/12
 * Time: 9:27 PM
 * To change this template use File | Settings | File Templates.
 */
public interface IMatcher<T> {
    public boolean matches ( T t ) throws Exception;
}
