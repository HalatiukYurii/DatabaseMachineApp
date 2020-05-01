package com.yurii.marviq_demoapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.yurii.marviq_demoapp.entity.Production;

public interface ProductionRepository extends CrudRepository<Production, Long> {
//	get sum of production in machine 4x2 brick mould

	@Query(value = "SELECT SUM(value)\r\n" + "FROM production\r\n"
			+ "WHERE datetime_from >= '2018-01-07T00:00:00.000'\r\n"
			+ "   AND datetime_to <= '2018-01-08T00:00:0.000' \r\n" + "   AND machine_name = '4x2 brick mould'\r\n"
			+ "   AND variable_name = 'PRODUCTION'", nativeQuery = true)
	int findSumProductionGross4x2();

//	get sum of scrap in machine 4x2 brick mould

	@Query(value = "SELECT SUM(value)\r\n" + "FROM production\r\n"
			+ "WHERE datetime_from >= '2018-01-07T00:00:00.000'\r\n"
			+ "   AND datetime_to <= '2018-01-08T00:00:0.000' \r\n" + "   AND machine_name = '4x2 brick mould'\r\n"
			+ "   AND variable_name = 'SCRAP'", nativeQuery = true)
	int findSumScrap4x2();

//	get sum of production in machine 3x2 brick mould

	@Query(value = "SELECT SUM(value)\r\n" + "FROM production\r\n"
			+ "WHERE datetime_from >= '2018-01-07T00:00:00.000'\r\n"
			+ "   AND datetime_to <= '2018-01-08T00:00:0.000' \r\n" + "   AND machine_name = '3x2 brick mould'\r\n"
			+ "   AND variable_name = 'PRODUCTION'", nativeQuery = true)
	int findSumProductionGross3x2();
	
//	get sum of scrap in machine 3x2 brick mould

	@Query(value = "SELECT SUM(value)\r\n" + "FROM production\r\n"
			+ "WHERE datetime_from >= '2018-01-07T00:00:00.000'\r\n"
			+ "   AND datetime_to <= '2018-01-08T00:00:0.000' \r\n" + "   AND machine_name = '3x2 brick mould'\r\n"
			+ "   AND variable_name = 'SCRAP'", nativeQuery = true)
	int findSumScrap3x2();

//	get sum of production in machine 2x2 brick mould

	@Query(value = "SELECT SUM(value)\r\n" + "FROM production\r\n"
			+ "WHERE datetime_from >= '2018-01-07T00:00:00.000'\r\n"
			+ "   AND datetime_to <= '2018-01-08T00:00:0.000' \r\n" + "   AND machine_name = '2x2 brick mould'\r\n"
			+ "   AND variable_name = 'PRODUCTION'", nativeQuery = true)
	int findSumProductionGross2x2();
	
//	get sum of scrap in machine 2x2 brick mould

	@Query(value = "SELECT SUM(value)\r\n" + "FROM production\r\n"
			+ "WHERE datetime_from >= '2018-01-07T00:00:00.000'\r\n"
			+ "   AND datetime_to <= '2018-01-08T00:00:0.000' \r\n" + "   AND machine_name = '2x2 brick mould'\r\n"
			+ "   AND variable_name = 'SCRAP'", nativeQuery = true)
	int findSumScrap2x2();
	
//	get information about net production in machine 4x2 brick mould

	@Query(value = "SELECT *\r\n" + "FROM production\r\n" + "WHERE datetime_from >= '2018-01-07T00:00:00.000'\r\n"
			+ "   AND datetime_to <= '2018-01-08T00:00:0.000' \r\n" + "   AND machine_name = '4x2 brick mould'"
			+ "   AND variable_name = 'PRODUCTION'", nativeQuery = true)
	List<Production> production_4x2();
	
//	get information about net production in machine 3x2 brick mould

	@Query(value = "SELECT *\r\n" + "FROM production\r\n" + "WHERE datetime_from >= '2018-01-07T00:00:00.000'\r\n"
			+ "   AND datetime_to <= '2018-01-08T00:00:0.000' \r\n" + "   AND machine_name = '3x2 brick mould'"
			+ "   AND variable_name = 'PRODUCTION'", nativeQuery = true)
	List<Production> production_3x2();
	
//	get information about net production in machine 2x2 brick mould

	@Query(value = "SELECT *\r\n" + "FROM production\r\n" + "WHERE datetime_from >= '2018-01-07T00:00:00.000'\r\n"
			+ "   AND datetime_to <= '2018-01-08T00:00:0.000' \r\n" + "   AND machine_name = '2x2 brick mould'"
			+ "   AND variable_name = 'PRODUCTION'", nativeQuery = true)
	List<Production> production_2x2();
	
//	get information about  scrap in machine 4x2 brick mould

	@Query(value = "SELECT *\r\n" + "FROM production\r\n" + "WHERE datetime_from >= '2018-01-07T00:00:00.000'\r\n"
			+ "   AND datetime_to <= '2018-01-08T00:00:0.000' \r\n" + "   AND machine_name = '4x2 brick mould'"
			+ "   AND variable_name = 'SCRAP'", nativeQuery = true)
	List<Production> scrap_4x2();
	
//	get information about  scrap in machine 3x2 brick mould

	@Query(value = "SELECT *\r\n" + "FROM production\r\n" + "WHERE datetime_from >= '2018-01-07T00:00:00.000'\r\n"
			+ "   AND datetime_to <= '2018-01-08T00:00:0.000' \r\n" + "   AND machine_name = '3x2 brick mould'"
			+ "   AND variable_name = 'SCRAP'", nativeQuery = true)
	List<Production> scrap_3x2();
	
//	get information about  scrap in machine 2x2 brick mould

	@Query(value = "SELECT *\r\n" + "FROM production\r\n" + "WHERE datetime_from >= '2018-01-07T00:00:00.000'\r\n"
			+ "   AND datetime_to <= '2018-01-08T00:00:0.000' \r\n" + "   AND machine_name = '2x2 brick mould'"
			+ "   AND variable_name = 'SCRAP'", nativeQuery = true)
	List<Production> scrap_2x2();
}
