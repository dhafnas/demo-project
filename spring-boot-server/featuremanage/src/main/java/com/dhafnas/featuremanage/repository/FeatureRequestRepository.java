package com.dhafnas.featuremanage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dhafnas.featuremanage.entity.FeatureRequest;

@Repository
public interface FeatureRequestRepository extends CrudRepository<FeatureRequest, Long> {

	public List<FeatureRequest> findByClientAndPriority(String client, int priority);

	@Query(nativeQuery = true, value = "with t as (\n" + "select l.priority+1 as start\n" + "from feature_request as l\n"
			+ "  left outer join feature_request as r on l.priority+ 1 = r.priority\n" + "where l.client = :client "
			+ " and r.priority is null\n" + "and l.priority >=:priority \n"
			+ "and l.priority < (select max(priority) from feature_request)\n" + ")\n"
			+ "select ifnull(min(t.start),0) from t")
	public int getUppperPriorityLimit(@Param("client") String client, @Param("priority") int priority);

	@Transactional
	@Modifying
	@Query(nativeQuery = true, value = "UPDATE feature_request f SET f.priority = f.priority+1 WHERE f.client = :client and f.priority >=:priorityFrom \n"
			+ "and (f.priority <= :priorityTo  OR 0 =:priorityTo)")
	public void updateFeatureRequestsPriority(@Param("client") String client, @Param("priorityFrom") int priorityFrom,
			@Param("priorityTo") int priorityTo);
}
