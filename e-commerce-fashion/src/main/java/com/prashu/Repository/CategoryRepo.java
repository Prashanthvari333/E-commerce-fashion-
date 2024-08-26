package com.prashu.Repository;

import com.prashu.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends JpaRepository<Category,Long> {

    Category findByName(String name);

    @Query("SELECT c from Category c WHERE c.name = :name AND c.parentCategory.name = :parentCategoryName")
    Category findByNameAndParent(@Param("name") String name, @Param("parentCategoryName") String parentCategoryName);
}
