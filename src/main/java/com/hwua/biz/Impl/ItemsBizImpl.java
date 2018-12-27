package com.hwua.biz.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hwua.biz.ItemsIBiz;
import com.hwua.dao.ItemsMapper;
import com.hwua.entity.Items;
import com.hwua.entity.QueryVo;

@Service
public class ItemsBizImpl implements ItemsIBiz {
	@Autowired
	private ItemsMapper idao;

	public PageInfo<Items> findGetAll(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<Items> list = idao.getItems();
		PageInfo<Items> pageInfo = new PageInfo<Items>(list);
		return pageInfo;
	}

	public List<Items> getAll() {
		List<Items> list = idao.getItems();
		return list;
	}

	public Items findById(Integer id) {
		Items item = idao.selectByPrimaryKey(id);
		return item;
	}

	public boolean updateItem(Items item) {
		int n = idao.updateByPrimaryKey(item);
		return n == 1 ? true : false;
	}

	public boolean deleteItem(Integer id) {
		int n = idao.deleteByPrimaryKey(id);
		return n == 1 ? true : false;
	}

	public boolean deleteEvery(String[] ids) {
		int row = 0; // 受影响的函数
		int count = 0;// 计数
		for (int i = 0; i < ids.length; i++) {
			row = idao.deleteByPrimaryKey(new Integer(ids[i]));
			if (row > 0) {
				count++;
			}
		}
		return (count == ids.length) ? true : false;

	}

	public boolean updateEvery(QueryVo vo, String[] ids) {

		int count = 0;// 计数
		List<Items> list = vo.getItemsList();
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < ids.length; j++) {
				//String 转换为 包装类 Integer
				Integer id = new Integer(ids[j]);
				if (id.equals(list.get(i).getId())) {
					// 执行修改操作
					int row = idao.updateByPrimaryKeySelective(list.get(i));
					if (row > 0) {
						count++;
					}
				}
			}
			
		}
		return (count == ids.length) ? true : false;
	}

	public boolean insertItem(Items item) {
		int n=idao.insert(item);
		return n == 1 ? true : false;
	}
}
