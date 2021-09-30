package demo01;

import lombok.Data;
import project.QyjAuditCalculationDTO;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Data
public class Task3 implements Runnable {
    private List<QyjAuditCalculationDTO> list;
    private long start;
    private long start2;

    public Task3(List<QyjAuditCalculationDTO> list,long start,long start2){
        this.list=list;
        this.start=start;
        this.start2=start2;
    }
    @Override
    public void run() {
        //研发投入额排名,得分
        investment(list,start,start2);
    }
    //研发投入额排名,得分
    public static void investment(List<QyjAuditCalculationDTO> qyjAuditCalculationDTOS,long start,long start2) {
        //研发投入额排名,得分
        List<QyjAuditCalculationDTO> totalTaxRand = qyjAuditCalculationDTOS.stream().sorted(Comparator.comparing(QyjAuditCalculationDTO::getInvestment).reversed()).collect(Collectors.toList());

        //判断totalTaxRand是否为空,totalTaxRand.size>0
        Optional.ofNullable(totalTaxRand).filter(l -> totalTaxRand.size() > 0).ifPresent(totalTaxRandList -> {
            for (int i = 0; i < totalTaxRandList.size(); i++) {
                System.out.println("investment"+i);
            }
            long end=System.currentTimeMillis();
            System.out.println("investment"+"-"+"end"+"共耗时"+(end-start)+"毫秒");
            System.out.println("investment"+"-"+"end"+"共耗时"+(end-start2)+"毫秒");
        });
    }
}
