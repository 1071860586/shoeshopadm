package com.hpe.ssa.service.impl;

import com.hpe.ssa.mapper.SpcifyShoesMapper;
import com.hpe.ssa.pojo.ShoeSizes;
import com.hpe.ssa.pojo.SpcifyShoes;
import com.hpe.ssa.service.SpcShoeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class SpcShoeServiceImpl implements SpcShoeService {

    @Autowired
    private SpcifyShoesMapper spcifyShoesMapper;
    @Override
    public int selectSpcShoesNum() {
        return spcifyShoesMapper.selectSpcShoesNum();
    }

    @Override
    public List<SpcifyShoes> selectSpcShoes4List(int index) {
        return spcifyShoesMapper.selectSpcShoes4List(index);
    }

    @Override
    public SpcifyShoes selectSpcShoeDetailById(int spsid) {
        return spcifyShoesMapper.selectSpcShoeDetailById(spsid);
    }

    @Override
    public int insertSpcShoe(SpcifyShoes spcifyShoe) {
        spcifyShoe.setSp_bid(Integer.valueOf(spcifyShoe.getBname()));
        spcifyShoe.setSp_tid(Integer.valueOf(spcifyShoe.getTname()));
        spcifyShoesMapper.insertSelective(spcifyShoe);
        Integer[] sizeChoose = spcifyShoe.getSizeChoose();
        int spid = spcifyShoe.getSpsid();
        List<ShoeSizes> shoeSizesList = new ArrayList<>();
        for (Integer i :sizeChoose ) {
            ShoeSizes shoeSize = new ShoeSizes();
            shoeSize.setS_sid(spid);
            shoeSize.setS_sizeid(i);
            shoeSize.setSstate(1);
            shoeSizesList.add(shoeSize);
        }
        return spcifyShoesMapper.insertSpcShoeSize(shoeSizesList);
    }

    @Override
    public int deleteSpcShoeById(int spsid) {

        spcifyShoesMapper.deleteSpcShoeSize(spsid);
        return spcifyShoesMapper.deleteSpcShoeById(spsid);
    }

    @Override
    public int updateSpcShoeInfo(SpcifyShoes spcifyShoe) {
        return spcifyShoesMapper.updateByPrimaryKeySelective(spcifyShoe);
    }
}
