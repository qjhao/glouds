package sin.glouds.temp;

import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;

public class EhcacheTest {

	public static void main(String[] args) {
		CacheManager cacheManager = CacheManagerBuilder
				.newCacheManagerBuilder()
				.withCache("firstCache", CacheConfigurationBuilder.newCacheConfigurationBuilder(Integer.class, String.class, ResourcePoolsBuilder.heap(100)).build())
				.build(true);
		Cache<Integer, String> firstCache = cacheManager.getCache("firstCache", Integer.class, String.class);
		firstCache.put(1, "Hello World!!!");
		System.out.println(firstCache.get(1));
		System.out.println(firstCache.get(0));
		cacheManager.close();
	}
}
