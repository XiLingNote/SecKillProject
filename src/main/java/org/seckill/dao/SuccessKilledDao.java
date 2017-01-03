
package org.seckill.dao;

import org.apache.ibatis.annotations.Param;
import org.seckill.entity.SuccessKilled;

/**
 * @author shou
 *
 */
public interface SuccessKilledDao {

	int insertSuccessKilled(@Param("seckillId") int seckillId, @Param("userPhone") int userPhone);
	SuccessKilled queryByIdWithSeckill(@Param("seckillId") int seckillId);
	
}
