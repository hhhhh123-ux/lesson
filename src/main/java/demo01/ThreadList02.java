package demo01;

import project.QyjAuditCalculationDTO;
import utils.IdUtils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class ThreadList02 {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int threadNum  = 5;//线程数
        ExecutorService eService = Executors.newFixedThreadPool(5);//创建一个线程池
        List<QyjAuditCalculationDTO> qyjAuditCalculationDTOS = new ArrayList<>();
        for (int i = 1; i < 100; i++) {
            QyjAuditCalculationDTO qyjAuditCalculationDTO = new QyjAuditCalculationDTO();
            qyjAuditCalculationDTO.setBaseId(String.valueOf(i));
            qyjAuditCalculationDTO.setInvestment(Double.valueOf(IdUtils.randomUUID5()));
            qyjAuditCalculationDTO.setProceedsSale(Double.valueOf(IdUtils.randomUUID5()));
            qyjAuditCalculationDTO.setProportionInvestment(Double.valueOf(IdUtils.randomUUID5()));
            qyjAuditCalculationDTO.setServiceOfficer(Double.valueOf(IdUtils.randomUUID5()));
            qyjAuditCalculationDTO.setTotalTax(Double.valueOf(IdUtils.randomUUID5()));

            qyjAuditCalculationDTOS.add(qyjAuditCalculationDTO);
        }

        eService.submit((Runnable) qyjAuditCalculationDTOS);
        long start2 = System.currentTimeMillis();
        QyjAuditCalculationDTO thread=new QyjAuditCalculationDTO();
        new Thread(thread).start();
        //纳税总额排名,得分
        totalTax(qyjAuditCalculationDTOS);
        // 销售收入排名,得分
        proceedsSale(qyjAuditCalculationDTOS);
        //在职人员数排名,得分
        serviceOfficer(qyjAuditCalculationDTOS);
        //研发投入额排名,得分
        investment(qyjAuditCalculationDTOS);
        //研发投入占比排名,得分
        proportionInvestment(qyjAuditCalculationDTOS);
        long end = System.currentTimeMillis();
        System.out.println("共耗时"+(start-end)+"毫秒");
        System.out.println("共耗时"+(start2-end)+"毫秒");
    }

    //纳税总额排名,得分
   static void totalTax(List<QyjAuditCalculationDTO> qyjAuditCalculationDTOS) {
        //纳税总额排名
        List<QyjAuditCalculationDTO> totalTaxRand = qyjAuditCalculationDTOS.stream().sorted(Comparator.comparing(QyjAuditCalculationDTO::getTotalTax).reversed()).collect(Collectors.toList());
        //判断totalTaxRand是否为空,totalTaxRand.size>0
        Optional.ofNullable(totalTaxRand).filter(l -> totalTaxRand.size() > 0).ifPresent(totalTaxRandList -> {
           //
            //
                    for (int i = 0; i < totalTaxRandList.size(); i++) {
                        System.out.println("totalTax" + i);
                    }
        });
    }

    // 销售收入排名,得分
    public static void proceedsSale(List<QyjAuditCalculationDTO> qyjAuditCalculationDTOS) {
        //销售收入排名,得分
        List<QyjAuditCalculationDTO> totalTaxRand = qyjAuditCalculationDTOS.stream().sorted(Comparator.comparing(QyjAuditCalculationDTO::getProceedsSale).reversed()).collect(Collectors.toList());
        Optional.ofNullable(totalTaxRand).filter(l -> totalTaxRand.size() > 0).ifPresent(totalTaxRandList -> {
                    for (int i = 0; i < totalTaxRandList.size(); i++) {
                        System.out.println("proceedsSale"+i);
                    }

        });

    }

    //在职人员数排名,得分
    public static void serviceOfficer(List<QyjAuditCalculationDTO> qyjAuditCalculationDTOS) {
        //在职人员数排名,得分
        List<QyjAuditCalculationDTO> totalTaxRand = qyjAuditCalculationDTOS.stream().sorted(Comparator.comparing(QyjAuditCalculationDTO::getServiceOfficer).reversed()).collect(Collectors.toList());
        //判断totalTaxRand是否为空,totalTaxRand.size>0
        Optional.ofNullable(totalTaxRand).filter(l -> totalTaxRand.size() > 0).ifPresent(totalTaxRandList -> {
                    for (int i = 0; i < totalTaxRandList.size(); i++) {
                        System.out.println("serviceOfficer"+i);
                    }

        });
    }

    //研发投入额排名,得分
    public static void investment(List<QyjAuditCalculationDTO> qyjAuditCalculationDTOS) {
        //研发投入额排名,得分
        List<QyjAuditCalculationDTO> totalTaxRand = qyjAuditCalculationDTOS.stream().sorted(Comparator.comparing(QyjAuditCalculationDTO::getInvestment).reversed()).collect(Collectors.toList());

        //判断totalTaxRand是否为空,totalTaxRand.size>0
        Optional.ofNullable(totalTaxRand).filter(l -> totalTaxRand.size() > 0).ifPresent(totalTaxRandList -> {
                    for (int i = 0; i < totalTaxRandList.size(); i++) {
                        System.out.println("investment"+i);
                    }

        });
    }

    //研发投入占比排名,得分
    public static void proportionInvestment(List<QyjAuditCalculationDTO> qyjAuditCalculationDTOS) {
        //研发投入占比排名,得分
        List<QyjAuditCalculationDTO> totalTaxRand = qyjAuditCalculationDTOS.stream().sorted(Comparator.comparing(QyjAuditCalculationDTO::getProportionInvestment).reversed()).collect(Collectors.toList());

        //判断totalTaxRand是否为空,totalTaxRand.size>0
        Optional.ofNullable(totalTaxRand).filter(l -> totalTaxRand.size() > 0).ifPresent(totalTaxRandList -> {
            for (int i = 0; i < totalTaxRandList.size(); i++) {
                System.out.println("proportionInvestment"+i);
            }

        });
    }


}



