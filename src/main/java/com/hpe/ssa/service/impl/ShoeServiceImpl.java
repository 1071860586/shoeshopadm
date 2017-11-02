package com.hpe.ssa.service.impl;

import com.hpe.ssa.mapper.ShoesMapper;
import com.hpe.ssa.pojo.ShoeSizes;
import com.hpe.ssa.pojo.Shoes;
import com.hpe.ssa.pojo.Shoes4List;
import com.hpe.ssa.service.ShoeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Service
public class ShoeServiceImpl implements ShoeService {

    @Autowired
    private ShoesMapper shoesMapper;
    @Override
    public List<Shoes4List> selectShoes4List(int index) {

        return shoesMapper.selectShoes4List(index);
    }

    @Override
    public Shoes selectShoeDetailById(int sid) {
        shoesMapper.selectShoeSizeById(sid);
        Shoes shoe = shoesMapper.selectShoeDetailById(sid);
        shoe.setSizeList( shoesMapper.selectShoeSizeById(sid));
        return shoe;
    }
    //Shoes{sid=null, stid=null, tname='1', sbid=null, bname='1', snum='11231', sname='dddd', sprices=123.0,
    // sdiscount=null, spubtime=Tue Oct 03 00:00:00 CST 2017, sproducer='123123', sgender='男', scolor='123df',
    // sinfo='1231', stimesold=123, simage='null', sdetail='123213', sintegral=1231.0, sdelete=0,
    // sremarks='null', sandroidimg='null', sizeList=null, sizeChoose=[2, 3, 5, 6, 7, 9, 10, 11]}
    @Override
    public int insertShoe(Shoes shoe) {
        shoe.setStid(Integer.valueOf(shoe.getTname()));
        shoe.setSbid(Integer.valueOf(shoe.getBname()));
        shoesMapper.insertSelective(shoe);
        Integer[] sizeChoose = shoe.getSizeChoose();
        int sid = shoe.getSid();
        List<ShoeSizes> shoeSizesList = new ArrayList<>();
        for (Integer i :sizeChoose ) {
            ShoeSizes shoeSize = new ShoeSizes();
            shoeSize.setS_sid(sid);
            shoeSize.setS_sizeid(i);
            shoeSize.setSstate(1);
            shoeSize.setScount(50);
            shoeSizesList.add(shoeSize);
        }
        return shoesMapper.insertShoeSize(shoeSizesList);
    }

    @Override
    public int updateShoeState(int delid, int del) {
        Shoes shoe= new Shoes();
        shoe.setSid(delid);
        shoe.setSdelete(del);
        return shoesMapper.updateShoeState(shoe);
    }

    @Override
    public int updateShoeInfo(Shoes shoe) {
        shoe.setStid(Integer.valueOf(shoe.getTname()));
        shoe.setSbid(Integer.valueOf(shoe.getBname()));
        return shoesMapper.updateByPrimaryKeySelective(shoe);
    }

    @Override
    public int selectShoesNum() {
        return shoesMapper.selectShoesNum();
    }
}
