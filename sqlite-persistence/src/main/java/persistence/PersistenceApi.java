package persistence;

import persistence.model.DailyDataBean;
import persistence.model.GrowPeriodEntity;
import persistence.model.PortDataEntity;
import persistence.model.PortEntity;

import java.time.LocalDate;
import java.util.List;

public interface PersistenceApi {

    int getGPIOPort(String portId) throws Exception;

    PortEntity getPort(String portId);

    List<PortEntity> getPorts();

    PortDataEntity getPortData(String portId);

    List<PortDataEntity> getLatestPortData(String portId, int limit);

    List<DailyDataBean> getDailyPortData(LocalDate startDate, LocalDate endDate, String portId);

    void createPortData(PortDataEntity portDataEntity);

    void updateGrowPeriod(GrowPeriodEntity growPeriodEntity);

    GrowPeriodEntity getGrowPeriod(int id);

    List<GrowPeriodEntity> getGrowPeriods();

    void createGrowPeriods(GrowPeriodEntity growPeriodEntity);
}
