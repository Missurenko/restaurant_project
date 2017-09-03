package edu.bionic.dao;


import edu.bionic.domain.my.Material;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by bm on 27.08.17.
 */
public interface MaterialDao {


    List<Material> getAllSortedByName(String name, BigDecimal min, BigDecimal max,
                            String provider, LocalDateTime time,
                            boolean desc, int offset, int limit);

    List<Material> getCount(String name, BigDecimal min, BigDecimal max,
                            String provider, LocalDateTime time);


    List<Material> getAllSortedByPrice(String name, BigDecimal min, BigDecimal max, String provider, LocalDateTime time, boolean desk, int offset, int limit);
}
