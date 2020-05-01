package com.yurii.marviq_demoapp.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yurii.marviq_demoapp.entity.Production;
import com.yurii.marviq_demoapp.repository.ProductionRepository;

@Controller
public class ProductionController {
	@GetMapping("/")
	public String index() {
		return "index";
	}

	@Autowired
	public ProductionRepository productionRepository;

	@GetMapping("/all")
	public String getAllProductions(Model model) {
		List<Production> datas = (List<Production>) productionRepository.findAll();
		model.addAttribute("datas", datas);
		model.addAttribute("status", true);
		return "find-all";
	}

//      method for remove twelve first elements of general list
	public List<Production> remove12FierstElements(List<Production> list) {
		try {
			for (int i = 0; i <= 11; i++) {
				list.remove(list.get(i));
			}
		} catch (Exception e) {
			System.out.println("Something went wrong.");

		}
		return list;

	}

	@GetMapping("/group_by_hour")
	public String getProductionGroupByHour(Model model) {
//		 get database production and scrap and adding it to list
		List<Production> listProduction = (List<Production>) productionRepository.production_2x2();
		List<Production> listScrap = (List<Production>) productionRepository.scrap_2x2();

		List<Integer> listOfNetProdaction = new ArrayList<>();
		do {
//         get twenty items from general list
			List<Production> take12ItemsProduction = new ArrayList<>();
			take12ItemsProduction = listProduction.stream().limit(12).collect(Collectors.toList());
//			get value of productions and scrap and sum it
			int sumProduction = take12ItemsProduction.stream().mapToInt(w -> w.getValue()).sum();
			List<Production> take12ItemsScrap = new ArrayList<>();
			take12ItemsScrap = listScrap.stream().limit(12).collect(Collectors.toList());
			int sumScrap = take12ItemsScrap.stream().mapToInt(w -> w.getValue()).sum();

//          production net
			int netProduction = sumProduction - sumScrap;
//          add production to list
			listOfNetProdaction.add(netProduction);
//          remove twelve first elements from general list
			remove12FierstElements(listProduction);
			remove12FierstElements(listScrap);
		} while (listProduction.isEmpty() == false);
		List<Production> forModel = new ArrayList<>();
	    forModel =  (List<Production>) productionRepository.production_2x2();
		model.addAttribute("forMOdel", forModel.stream().limit(1).collect(Collectors.toList()));
		model.addAttribute("status", true);
		model.addAttribute("listOfNetProdaction", listOfNetProdaction.stream().limit(24).collect(Collectors.toList()));
		model.addAttribute("status", true);
		return "group-by-hour";
	}

	@GetMapping("/part1")
	public String getPart1(Model model) {
//		get information about net production in machine 2x2 brick mould
		List<Production> datas2x2 = (List<Production>) productionRepository.production_2x2();
		int production = productionRepository.findSumProductionGross2x2() - productionRepository.findSumScrap2x2();
		Production p = new Production(datas2x2.get(0).getDatetimeFrom(),
				datas2x2.get(datas2x2.size() - 1).getDatetimeTo(), datas2x2.get(0).getMachineName(),
				datas2x2.get(0).getVariableName(), production);
//		get information about net production in machine 2x2 brick mould
		List<Production> datas3x2 = (List<Production>) productionRepository.production_3x2();
		int production3 = productionRepository.findSumProductionGross3x2() - productionRepository.findSumScrap3x2();
		Production p3 = new Production(datas3x2.get(0).getDatetimeFrom(),
				datas3x2.get(datas3x2.size() - 1).getDatetimeTo(), datas3x2.get(0).getMachineName(),
				datas3x2.get(0).getVariableName(), production3);
//		get information about net production in machine 2x2 brick mould
		List<Production> datas4x2 = (List<Production>) productionRepository.production_4x2();
		int production4 = productionRepository.findSumProductionGross4x2() - productionRepository.findSumScrap4x2();
		Production p4 = new Production(datas4x2.get(0).getDatetimeFrom(),
				datas4x2.get(datas4x2.size() - 1).getDatetimeTo(), datas4x2.get(0).getMachineName(),
				datas4x2.get(0).getVariableName(), production4);
		List<Production> newList = new ArrayList<>();
		newList.add(p);
		newList.add(p3);
		newList.add(p4);
		model.addAttribute("newList", newList);
		model.addAttribute("status", true);

		return "production-part1";
	}
}
