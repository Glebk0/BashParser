package execution;

import java.util.HashSet;
import java.util.Iterator;
import dto.BrandDto;

public class MainExecutor {

    public static void main(String[] args){
        BrandDto brandDto = new BrandDto();
        brandDto.dataConnecter();
        String[] brands = {};
        brands = brandDto.getBrandsHashSet().toArray(new String[brandDto.getBrandsHashSet().size()]);
        for (int i=0; i<brands.length; i++){
            System.out.println(brands[i]);
        }
    }

}
