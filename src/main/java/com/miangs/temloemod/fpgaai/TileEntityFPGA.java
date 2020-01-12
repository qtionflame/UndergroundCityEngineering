package com.miangs.temloemod.fpgaai;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldServer;

/**
 * Creative by GoldMain on 2019/12/14
 */
public class TileEntityFPGA extends TileEntity
implements ITickable
{
    public int progress = 0;
    private long microJoules = 0;
    public TileEntityFPGA()
    {
    }
    /*
    * BC并没有使用假人!!!
    * 坑！
    * */
    
    @Override
    public void update()
    {
    	if(world==null||this.world.isRemote)return;
        
        //EntityPlayerMP player = ModFakePlayerLoader.getFakePlayer((WorldServer) world).get();
        
        //if(player==null)return;
    	
        BlockPos pos = this.pos.down();
        
        while(pos.getY()>=0)
        {
            IBlockState block = world.getBlockState(pos);
            if(block.getMaterial()!= Material.AIR)
            {
            	//  if(player.interactionManager==null)return;
            	IBlockState state = world.getBlockState(pos);
            	//获取方块的硬度，求出需要破坏的时间
            	float hardness = state.getBlockHardness(world,pos);
            	
            	//求出破坏总耗时
            	long target = (long) Math.floor(16 * 1_000_000L * ((hardness + 1) * 2) * 1);
            	//当前破坏进度
            	progress += extractPower(0,target-progress);
            	//当前进度大于总耗时时破坏掉方块
            	if(progress>=target)
            	{
            		progress=0;
            		//消除所有裂痕并破坏掉
            	
            		
            		world.sendBlockBreakProgress(pos.hashCode(),pos,-1);
            		//挖完了物品掉落
            		world.destroyBlock(pos,true);
            		
            		
            		//world.getBlockState(pos.up()).getBlock().equals(Blocks.CHEST);
            		
            		 if(world.getBlockState(this.pos.up()).getBlock() == Blocks.CHEST)
            		 {
            			 System.out.println("箱子在！");
            			 
            			 
            			// chest.setInventorySlotContents(j,new ItemStack(Blocks.LOG,64));
            		 }
            		
            		
            		
            		
            	}else
            	{
                        //修改方块的裂痕进程 最后一个参数范围0-9
                        world.sendBlockBreakProgress(pos.hashCode(),pos,(int)((progress*9)/target));
            	}
                    break;
                }else
                {
                    pos = pos.down();
                }
        }
    }
    public long extractPower(long min, long max)
    {
    	/*
		    于BC的源码有变动
		    这里可以调数
		    返回的值越大，效率越高
        if (microJoules < min) return 0;
        long extracting = Math.min(microJoules, max);
        microJoules -= extracting;
        */
    	
        return 1000000;
    }
}
