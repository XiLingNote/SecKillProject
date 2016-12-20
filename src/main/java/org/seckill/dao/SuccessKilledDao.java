
package org.seckill.dao;

import org.seckill.entity.SeccessKilled;

/**
 * @author shou
 *
 */
public interface SuccessKilledDao {

	int insertSuccessKilled(int seckillid, int userphone);
	SeccessKilled queryByIdWithSeckill(int seckillId);
	
}
