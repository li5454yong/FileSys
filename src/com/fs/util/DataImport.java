package com.fs.util;

/**
 * 定时执行增量solr索引任务
 * @author lxg
 *
 * 2016年5月2日下午9:34:19
 */
public class DataImport {

	public void process(){
		HttpsUtil.Get("http://localhost:8090/solr/dataimport-file?command=delta-import&commit=ture");
		HttpsUtil.Get("http://localhost:8090/solr/dataimport-category?command=delta-import&commit=ture");
	}
}
