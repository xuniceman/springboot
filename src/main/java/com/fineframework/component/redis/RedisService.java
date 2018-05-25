package com.fineframework.component.redis;

public interface RedisService {
	/**
	 * 写入
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	public void set(final String key, Object value);

	/**
	 * 写入并设置时效时间
	 * 
	 * @param key
	 * @param value
	 * @param expireTime
	 *            有效时间
	 * @return
	 */
	public void set(final String key, Object value, Long expireTime);

	/**
	 * 批量删除值
	 * 
	 * @param keys
	 */
	public void remove(final String... keys);

	/**
	 * 批量删除键（key）
	 * 
	 * @param pattern
	 */
	public void removePattern(final String pattern);

	/**
	 * 删除值
	 * 
	 * @param key
	 */
	public void remove(final String key);

	/**
	 * 判断缓存中是否有对应的键值
	 * 
	 * @param key
	 * @return
	 */
	public boolean exists(final String key);

	/**
	 * 根据键获取值
	 * 
	 * @param key
	 * @return
	 */
	public Object get(final String key);

	

}
