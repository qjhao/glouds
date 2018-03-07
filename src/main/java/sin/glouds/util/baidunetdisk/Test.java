package sin.glouds.util.baidunetdisk;

import java.io.IOException;

import sin.glouds.util.baidunetdisk.sopanpan.bean.Result;
import sin.glouds.util.baidunetdisk.sopanpan.bean.Results;
import sin.glouds.util.baidunetdisk.sopanpan.bean.SoPanInfo;
import sin.glouds.util.baidunetdisk.sopanpan.bean.SoPanInfo.TYPE;
import sin.glouds.util.baidunetdisk.sopanpan.service.SoPanService;

public class Test {

	public static void main(String[] args) throws IOException {
		Results results = SoPanService.search(new SoPanInfo("盘龙", TYPE.文档));
		for(Result result : results) {
			System.out.println(result.getName());
			System.out.println(result.getUrl());
			System.out.println();
		}
	}
}
