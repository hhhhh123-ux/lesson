package demo01;

import project.QyjAuditCalculationDTO;
import utils.IdUtils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import java.util.stream.Collectors;

public class ThreadList02  {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        List<QyjAuditCalculationDTO> qyjAuditCalculationDTOS = new ArrayList<>();
        for (int i = 1; i < 1000001; i++) {
            QyjAuditCalculationDTO qyjAuditCalculationDTO = new QyjAuditCalculationDTO();
            qyjAuditCalculationDTO.setBaseId(String.valueOf(i));
            qyjAuditCalculationDTO.setInvestment(Double.valueOf(IdUtils.randomUUID5()));
            qyjAuditCalculationDTO.setProceedsSale(Double.valueOf(IdUtils.randomUUID5()));
            qyjAuditCalculationDTO.setProportionInvestment(Double.valueOf(IdUtils.randomUUID5()));
            qyjAuditCalculationDTO.setServiceOfficer(Double.valueOf(IdUtils.randomUUID5()));
            qyjAuditCalculationDTO.setTotalTax(Double.valueOf(IdUtils.randomUUID5()));
            qyjAuditCalculationDTOS.add(qyjAuditCalculationDTO);
        }
        long start2 = System.currentTimeMillis();
        Thread thread1=new Thread(new Task(qyjAuditCalculationDTOS,start,start2));
        Thread thread2=new Thread(new Task1(qyjAuditCalculationDTOS,start,start2));
        Thread thread3=new Thread(new Task2(qyjAuditCalculationDTOS,start,start2));
        Thread thread4=new Thread(new Task3(qyjAuditCalculationDTOS,start,start2));
        Thread thread5=new Thread(new Task4(qyjAuditCalculationDTOS,start,start2));
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
//        //纳税总额排名,得分
//        totalTax(qyjAuditCalculationDTOS);
//        // 销售收入排名,得分
//        proceedsSale(qyjAuditCalculationDTOS);
//        //在职人员数排名,得分
//        serviceOfficer(qyjAuditCalculationDTOS);
//        //研发投入额排名,得分
//        investment(qyjAuditCalculationDTOS);
//        //研发投入占比排名,得分
//        proportionInvestment(qyjAuditCalculationDTOS);
        long end = System.currentTimeMillis();
        System.out.println("共耗时"+(end-start)+"毫秒");
        System.out.println("共耗时"+(end-start2)+"毫秒");
        System.out.println(qyjAuditCalculationDTOS.size());
    }

    //纳税总额排名,得分
   public static void totalTax(List<QyjAuditCalculationDTO> qyjAuditCalculationDTOS) {
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



