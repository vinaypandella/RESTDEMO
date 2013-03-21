package com.commerce;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface TestMapper {
	
	final String INSERT_ITEM = "insert into ITM_STYL_CLR(STYL_CLR_NBR,DESCRIPTION, COLR, STYLE, PRICE)values(#{style_color_number}, #{desc}, #{colr}, #{style},#{price})";
    @Insert(INSERT_ITEM)
    void insertItem(@Param("style_color_number") String styleColorNumber,
                    @Param("desc") String desc,
                    @Param("colr") String colr,
                    @Param("style") String style,
                    @Param("price") int price);

}
