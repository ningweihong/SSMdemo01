package com.hwua.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hwua.biz.ItemsIBiz;
import com.hwua.entity.Items;
import com.hwua.entity.QueryVo;
import com.hwua.exception.CustomException;

@Controller
@RequestMapping("/item")
public class ItemsController {
	@Resource(name = "itemsBizImpl")
	private ItemsIBiz ibiz;

	/**
	 * 
	 * @Title: demo01 @Description: TODO(查询所有) @param: @return @return:
	 *         ModelAndView @throws
	 */
	@RequestMapping("/demo01")
	public ModelAndView demo01() {
		// System.out.println("zaijinlai");
		List<Items> itemList = ibiz.getAll();
		ModelAndView mv = new ModelAndView();
		mv.addObject("itemList", itemList);
		mv.setViewName("demo01");
		return mv;

	}

	/**
	 * @throws CustomException
	 * 
	 * @Title: demo02 @Description: TODO(修改前 --查询) @param: @param id @param: @param
	 *         model @param: @return @return: String @throws
	 */
	@RequestMapping("/demo02")
	public String demo02(Integer id, Model model) throws CustomException {
		// System.out.println(id);
		Items item = ibiz.findById(id);
		if (item == null) {
			throw new CustomException("该商品未存在");

		} else {
			model.addAttribute("item", item);
			return "demo02";
		}

	}

	/**
	 * 修改成功 @Title: edit @Description: TODO(这里用一句话描述这个方法的作用) @param: @param
	 * items @param: @param response @param: @return @param: @throws
	 * IOException @return: String @throws
	 */
	@RequestMapping("/update")
	public String edit(Items items, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		// System.out.println(items.getCreatetime());
		boolean flag = ibiz.updateItem(items);
		if (flag) {// 修改成功
			return "redirect:demo01.action";
		} else {
			out.write("<script>alert('修改失败！');</script>");
			return null;
		}
	}

	/**
	 * 单删除 @Title: demo03 @Description: TODO(这里用一句话描述这个方法的作用) @param: @param
	 * id @param: @return @param: @throws CustomException @return: String @throws
	 */
	@RequestMapping("/del")
	public String demo03(Integer id, HttpServletResponse response) throws CustomException {
		boolean n = ibiz.deleteItem(id);
		if (!n) {
			throw new CustomException("删除失败");
		} else {
			try {
				response.sendRedirect("demo01");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	/**
	 * 跳转到到添加页面 @Title: show1 @Description:
	 * TODO(这里用一句话描述这个方法的作用) @param: @return @return: String @throws
	 */
	@RequestMapping("/addItem")
	public String show1() {
		// System.out.println("jinlai");
		return "demo03";

	}

	/**
	 * 添加 @Title: add @Description: TODO(这里用一句话描述这个方法的作用) @param: @param
	 * items @param: @return @param: @throws CustomException @return: String @throws
	 * 
	 * @throws IOException
	 */
	@RequestMapping("/demo04")
	public String demo04(Items items, HttpServletResponse response) throws IOException {

		boolean n = ibiz.insertItem(items);
		if (!n) {
			response.getWriter().println("<script>alert('删除失败！');</script>");
		} else {
			try {
				response.sendRedirect("demo01");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	/*
	 * public String demo(@PathVariable String forname) { return forname; }
	 */
	@RequestMapping("/{forname}")
	public ModelAndView demo04(@PathVariable String forname) {
		// System.out.println("zaijinlai");
		List<Items> itemList = ibiz.getAll();
		ModelAndView mv = new ModelAndView();
		mv.addObject("itemList", itemList);
		mv.setViewName(forname);
		return mv;

	}

	/**
	 * @throws IOException @throws CustomException 批量修改 @Title:
	 * doupdate @Description: TODO(这里用一句话描述这个方法的作用) @param: @param vo @param: @param
	 * ids @param: @return @return: ModelAndView @throws
	 */
	@RequestMapping("/doupdate1")
	public void doupdate(QueryVo vo, String[] ids, HttpServletResponse response) throws IOException {
		boolean falg = ibiz.updateEvery(vo, ids);
		if (falg) {
			response.sendRedirect("demo01");
		} else {
			response.getWriter().println("<script>alert('修改失败！');</script>");
		}

	}

	@RequestMapping("/dodelete1")
	public void dodelete(String[] ids, HttpServletResponse response) throws IOException  {
		boolean falg = ibiz.deleteEvery(ids);
		if (falg) {
				response.sendRedirect("demo01");
		} else {
			response.getWriter().println("<script>alert('删除失败！');</script>");
		}

	}
	@RequestMapping(value=("/test/{id}") ,method=RequestMethod.GET)
	public @ResponseBody boolean test(@PathVariable("id") Integer id ,HttpServletRequest request) {
		System.out.println(id);
		boolean n=ibiz.deleteItem(id);
		
		return n;
		}
}
