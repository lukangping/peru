package com.peru.webapp;

import com.peru.dal.ReportDailyDO;
import com.peru.dal.ReportDailyDOCriteria;
import com.peru.dal.ReportDailyDOMapper;
import com.peru.dal.ReportHourlyDO;
import com.peru.dal.ReportHourlyDOCriteria;
import com.peru.dal.ReportHourlyDOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by roger.lu on 2018/5/11.
 */
@Controller
public class ReportController {


  @Autowired
  private ReportDailyDOMapper reportDailyDOMapper;

  @Autowired
  private ReportHourlyDOMapper reportHourlyDOMapper;

  @RequestMapping(value = "/query", method = RequestMethod.GET)
  @ResponseBody
  public List<ReportHourlyDO> doGet(String facebook_id, String start_date, String start_hour,
                      String end_date, String end_hour) {

    ReportHourlyDOCriteria reportHourlyDOCriteria = new ReportHourlyDOCriteria();
    ReportHourlyDOCriteria.Criteria criteria = reportHourlyDOCriteria.createCriteria();
    criteria.andFacebookIdEqualTo(facebook_id);
    criteria.andDateGreaterThanOrEqualTo(Integer.parseInt(start_date + start_hour));
    criteria.andDateLessThan(Integer.parseInt(end_date + end_hour));

    List<ReportHourlyDO> reportHourlyDOs = reportHourlyDOMapper.selectByExample(reportHourlyDOCriteria);

    return reportHourlyDOs;
  }

  @RequestMapping(value = "/query/daily", method = RequestMethod.GET)
  @ResponseBody
  public List<ReportDailyDO> queryDaily(String facebook_id, String start_date, String start_hour,
                                    String end_date, String end_hour) {

    ReportDailyDOCriteria reportDailyDOCriteria = new ReportDailyDOCriteria();
    ReportDailyDOCriteria.Criteria criteria = reportDailyDOCriteria.createCriteria();
    criteria.andFacebookIdEqualTo(facebook_id);
    criteria.andDateGreaterThanOrEqualTo(Integer.parseInt(start_date));
    criteria.andDateLessThanOrEqualTo(Integer.parseInt(end_date));
    List<ReportDailyDO> reportDailyDOs = reportDailyDOMapper.selectByExample(reportDailyDOCriteria);

    for (ReportDailyDO reportDailyDO : reportDailyDOs) {

      BigDecimal gmv = reportDailyDO.getGmv();
      BigDecimal generalCost = reportDailyDO.getCostGeneral();
      BigDecimal vendorCost = reportDailyDO.getCostPurchasing();
      BigDecimal spend = reportDailyDO.getSpend();

      if (null != gmv && null != generalCost && null != vendorCost && null != spend) {
        BigDecimal earning = gmv.subtract(generalCost).subtract(vendorCost).subtract(spend);
        BigDecimal profit = gmv.subtract(generalCost).subtract(vendorCost);
        float roi = profit.floatValue() / spend.floatValue();

        reportDailyDO.setEarning(earning);
        reportDailyDO.setRoi(Float.valueOf(String.format("%.2f", roi)));

      }

    }

    return reportDailyDOs;
  }
}
