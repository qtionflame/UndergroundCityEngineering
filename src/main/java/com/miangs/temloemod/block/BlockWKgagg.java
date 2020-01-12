package com.miangs.temloemod.block;

import javax.annotation.Nullable;

import com.miangs.temloemod.entity.FakePlayerLoader;
import com.miangs.temloemod.fpgaai.TileEntityFPGA;

import net.minecraft.block.BlockDirectional;
import net.minecraft.block.material.EnumPushReaction;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.network.play.server.SPacketBlockChange;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

public class BlockWKgagg extends BlockDirectional
{
	public BlockWKgagg()
	{
		super(Material.ROCK);
		setCreativeTab(CreativeTabs.REDSTONE);
		setUnlocalizedName("BolmgGolm");
		setRegistryName("bolmg_golm");//名字是: modID:bolmg_golm
		
		this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.UP));
		
		
		
	}
	
	
	
	
	

   /*
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
		return true;
    }
	*/
	
	  @Override
	  public boolean hasTileEntity(IBlockState state)
	  {
		  return true;
	  }
	  @Nullable
	  @Override
	  public TileEntity createTileEntity(World world, IBlockState state)
	  {
		  return new TileEntityFPGA();
	  }

	  
	
	/*--------------------------------------------------------------------------------------*/
	
	/**
     * 从传递的blockstate返回具有给定旋转的blockstate。如果不适用，则返回通过的封锁状态。
     */
	@Override
    public IBlockState withRotation(IBlockState state, Rotation rot)
    {
        return state.withProperty(FACING, rot.rotate((EnumFacing)state.getValue(FACING)));
    }
	
    /**
     * 从传递的blockstate返回具有给定旋转的blockstate。如果不适用，则返回通过的封锁状态。
     */
	@Override
    public IBlockState withMirror(IBlockState state, Mirror mirrorIn)
    {
        return state.withProperty(FACING, mirrorIn.mirror((EnumFacing)state.getValue(FACING)));
    }
	
    /**
    *在实际设置块之前由ItemBlocks调用，以允许对
    *伊布洛克状态
    */
	@Override
    public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
    {
		return this.getDefaultState().withProperty(FACING, facing.getOpposite());
        
        //return this.getDefaultState().withProperty(FACING, EnumFacing.getDirectionFromEntityLiving(pos, placer).getOpposite());
    }
	
    /**
    *将给定的元数据转换为此块的块状态
    */
	@Override
    public IBlockState getStateFromMeta(int meta)
    {
 
    	 return this.getDefaultState().withProperty(FACING, EnumFacing.getFront(meta));
    	 
    }
	
	/**
	*将块状态转换为正确的元数据值
	*/
	@Override
    public int getMetaFromState(IBlockState state)	//从状态获取元
    {
        return ((EnumFacing)state.getValue(FACING)).getIndex();
    }
    
    /*--------------------------------------------------------------------------------------*/
	@Override
    protected BlockStateContainer createBlockState()	//块状态容器
    {
        return new BlockStateContainer(this, new IProperty[] {FACING});
    }
    /*--------------------------------------------------------------------------------------*/
	@Override
    public EnumPushReaction getMobilityFlag(IBlockState state)	//获取移动方块
    {
        return EnumPushReaction.NORMAL;
    }
	/*--------------------------------------------------------------------------------------*/
	/**
	*获取查询面在给定位置和状态下的几何图形。这是用来决定
	*按钮可以放置在面上，或者玻璃面板如何与面连接，等等。
	*<p>
	*常见的值是{@code SOLID}，这是默认值，还有{@code UNDEFINED}，它表示
	*与其他描述不符，通常会导致其他事物与面部不相连。
	*
	*@返回给定表面形式的近似值
	*/
	@Override
    public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face)
    {
        return BlockFaceShape.SOLID;
    }
}
