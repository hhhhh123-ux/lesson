package thread.demo01;

import lombok.Data;
import thread.project.QyjAuditCalculationDTO;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Data
public class Task implements Runnable{
    private List<QyjAuditCalculationDTO> list;
    private long start;
    private long start2;
    public Task(List<QyjAuditCalculationDTO> list,long start,long start2){
        this.list=list;
        this.start=start;
        this.start2=start2;
    }
    @Override
    public void run() {
        //纳税总额排名,得分
        totalTax(list,start,start2);
    }

    //纳税总额排名,得分
    public static void totalTax(List<QyjAuditCalculationDTO> qyjAuditCalculationDTOS,long start,long start2) {
        //纳税总额排名
        List<QyjAuditCalculationDTO> totalTaxRand = qyjAuditCalculationDTOS.stream().sorted(Comparator.comparing(QyjAuditCalculationDTO::getTotalTax).reversed()).collect(Collectors.toList());
        //判断totalTaxRand是否为空,totalTaxRand.size>0
        Optional.ofNullable(totalTaxRand).filter(l -> totalTaxRand.size() > 0).ifPresent(totalTaxRandList -> {
            //
            //
            for (int i = 0; i < totalTaxRandList.size(); i++) {
                System.out.println("totalTax" + i);
            }
            long end=System.currentTimeMillis();
            System.out.println("totalTax"+"-"+"end"+"共耗时"+(end-start)+"毫秒");
            System.out.println("totalTax"+"-"+"end"+"共耗时"+(end-start2)+"毫秒");
        });
    }
}
