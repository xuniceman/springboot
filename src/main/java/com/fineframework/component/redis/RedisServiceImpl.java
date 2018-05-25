package com.fineframework.component.redis;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Component;

@Component
public class RedisServiceImpl implements RedisService {
	@Autowired
	private RedisTemplate<Object, Object> redisTemplate;

	/**
	 * 写入
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	public void set(final String key, Object value) {

		ValueOperations<Object, Object> operations = redisTemplate.opsForValue();
		operations.set(key, value);
	}

	/**
	 * 写入并设置时效时间
	 * 
	 * @param key
	 * @param value
	 * @param expireTime
	 *            有效时间
	 * @return
	 */
	public void set(final String key, Object value, Long expireTime) {
		ValueOperations<Object, Object> operations = redisTemplate.opsForValue();
		operations.set(key, value);
		redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
	}

	/**
	 * 批量删除值
	 * 
	 * @param keys
	 */
	public void remove(final String... keys) {
		for (String key : keys) {
			remove(key);
		}
	}

	/**
	 * 批量删除键（key）
	 * 
	 * @param pattern
	 */
	public void removePattern(final String pattern) {
		Set<Object> keys = redisTemplate.keys(pattern);
		if (keys.size() > 0) {
			redisTemplate.delete(keys);
		}

	}

	/**
	 * 删除值
	 * 
	 * @param key
	 */
	public void remove(final String key) {
		if (exists(key)) {
			redisTemplate.delete(key);
		}
	}

	/**
	 * 判断缓存中是否有对应的键值
	 * 
	 * @param key
	 * @return
	 */
	public boolean exists(final String key) {
		return redisTemplate.hasKey(key);
	}

	/**
	 * 根据键获取值
	 * 
	 * @param key
	 * @return
	 */
	public Object get(final String key) {
		Object result = null;
		ValueOperations<Object, Object> operations = redisTemplate.opsForValue();
		result = operations.get(key);
		return result;
	}

	/**
	 * 无序集合添加
	 * 
	 * @param key
	 * @param hashKey
	 * @param value
	 */
	public void hashSet(String key, Object hashKey, Object value) {
		HashOperations<Object, Object, Object> hash = redisTemplate.opsForHash();
		hash.put(key, hashKey, value);
	}

	/**
	 * 获取无序集合数据
	 * 
	 * @param key
	 * @param hashKey
	 * @return
	 */
	public Object hashGet(String key, Object hashKey) {
		HashOperations<Object, Object, Object> hash = redisTemplate.opsForHash();
		return hash.get(key, hashKey);
	}

	/**
	 * 列表添加
	 * 
	 * @param key
	 * @param value
	 */
	public void listPush(String key, Object value) {
		ListOperations<Object, Object> list = redisTemplate.opsForList();
		list.rightPush(key, value);
	}

	/**
	 * 获取列表
	 * 
	 * @param key
	 * @param la
	 * @param lb
	 * @return
	 */
	public List<Object> listRange(String key, long la, long lb) {
		ListOperations<Object, Object> list = redisTemplate.opsForList();
		return list.range(key, la, lb);
	}

	/**
	 * 有序集合添加
	 * 
	 * @param key
	 * @param value
	 */
	public void sSet(String key, Object value) {
		SetOperations<Object, Object> set = redisTemplate.opsForSet();
		set.add(key, value);
	}

	/**
	 * 有序集合获取
	 * 
	 * @param key
	 * @return
	 */
	public Set<Object> setMembers(String key) {
		SetOperations<Object, Object> set = redisTemplate.opsForSet();
		return set.members(key);
	}

	/**
	 * 有序集合添加
	 * 
	 * @param key
	 * @param value
	 * @param scoure
	 */
	public void zSet(String key, Object value, double scoure) {
		ZSetOperations<Object, Object> zset = redisTemplate.opsForZSet();
		zset.add(key, value, scoure);
	}

	/**
	 * 获取有序集合
	 * 
	 * @param key
	 * @param scoure
	 * @param scoure1
	 * @return
	 */
	public Set<Object> rangeByScore(String key, double scourea, double scoureb) {
		ZSetOperations<Object, Object> zset = redisTemplate.opsForZSet();
		return zset.rangeByScore(key, scourea, scoureb);
	}
}
