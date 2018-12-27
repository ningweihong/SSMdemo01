package com.hwua.biz;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.hwua.entity.Items;
import com.hwua.entity.QueryVo;

public interface ItemsIBiz {
	/**
	 * 
	 * @Title: findGetAll   
	 * @Description: TODO(分页查询)   
	 * @param: @param pageNum 第几页  
	 * @param: @param pageSize 一页几条数据
	 * @param: @return      
	 * @return: PageInfo<Items>      
	 * @throws
	 */
   public PageInfo<Items> findGetAll(int pageNum, int pageSize);
   /**
    * 查询所有的商品信息
    * @Title: getAll   
    * @Description: TODO(这里用一句话描述这个方法的作用)   
    * @param: @return      
    * @return: List<Items>      
    * @throws
    */
   public List<Items> getAll();
   /**
    * 根据id查询商品信息
    * @Title: findById   
    * @Description: TODO(这里用一句话描述这个方法的作用)   
    * @param: @param id
    * @param: @return      
    * @return: Items      
    * @throws
    */
   public Items findById(Integer id);
   /**
    * 修改商品信息
    * @Title: updateItem   
    * @Description: TODO(这里用一句话描述这个方法的作用)   
    * @param: @param item
    * @param: @return      
    * @return: boolean      
    * @throws
    */
   public boolean updateItem(Items item);
   /**
    * 根據Id刪除商品信息
    * @Title: deleteItem   
    * @Description: TODO(这里用一句话描述这个方法的作用)   
    * @param: @param id
    * @param: @return      
    * @return: boolean      
    * @throws
    */
   public boolean deleteItem(Integer id);
   /**
    * 批量删除
    * @Title: deleteEvery   
    * @Description: TODO(这里用一句话描述这个方法的作用)   
    * @param: @return      
    * @return: boolean      
    * @throws
    */
   public boolean deleteEvery(String[] ids);
   /**
    * 批量修改
    * @Title: updateEvery   
    * @Description: TODO(这里用一句话描述这个方法的作用)   
    * @param: @param vo
    * @param: @param ids
    * @param: @return      
    * @return: boolean      
    * @throws
    */
   public boolean updateEvery(QueryVo vo,String[] ids);
   public boolean insertItem(Items item);
}
