
### Text���

1.���塢������ɫ�����ֶ��뷽ʽ

```
<Text style={{fontSize:20, color:'red', {textAlign:'center'}}/>
```


2.������

```
<View style={{height:100, width:100, backgroundColor:'orange', borderRadius:5}}/>
```

3.Բ�Ǳ�����

```
<View style={{height:100, width:100, backgroundColor:'orange', borderRadius:5}}>
  <Text style={{flex:1,backgroundColor:'transparent'}}>Text Content</Text>
</View>
```

## Flex ����

### flex-direction

![flex-direction](res/flex-direction.jpg)

�������style��ָ��`flexDirection`���Ծ������ֵ����ᡣ
��Ԫ����Ӧ������ˮƽ��(`row`)�������У�����������ֱ��(`column`)���������أ�Ĭ��ֵ����ֱ��(`column`)����

���ӣ�[flex-direction](https://developer.mozilla.org/en-US/docs/Web/CSS/flex-direction)

### align-conent

![align-conent](res/align-conent.jpg)

���ӣ�[align-content](https://developer.mozilla.org/en-US/docs/Web/CSS/align-content)

### align-items

![align-items](res/align-items.jpg)

�������style��ָ��`alignItems`���Ծ�������Ԫ�����Ŵ��ᣨ�����ᴹֱ���ᣬ���������᷽��Ϊ`row`������᷽��Ϊ`column`�������з�ʽ��
��Ԫ����Ӧ�ÿ����������ʼ�˻���ĩβ�ηֲ��أ����Ӧ�þ��ȷֲ�����Ӧ����Щ��ѡ���У�`flex-start`��`center`��`flex-end`�Լ�`stretch`��

ע�⣺Ҫʹ`stretch`ѡ����Ч�Ļ�����Ԫ���ڴ��᷽���ϲ����й̶��ĳߴ硣

���ӣ�[align-items](https://developer.mozilla.org/en-US/docs/Web/CSS/align-items)

### justify-content

![justify-content](res/justify-content.jpg)

�������style��ָ��`justifyContent`���Ծ�������Ԫ��������������з�ʽ��
��Ԫ����Ӧ�ÿ����������ʼ�˻���ĩβ�ηֲ��أ����Ӧ�þ��ȷֲ�����Ӧ����Щ��ѡ���У�`flex-start`��`center`��`flex-end`��`space-around`�Լ�`space-between`��

���ӣ�[justify-content](https://developer.mozilla.org/en-US/docs/Web/CSS/justify-content)

### flex-wrap

![flex-wrap](res/flex-wrap.jpg)

���ӣ�[flex-wrap](https://developer.mozilla.org/en-US/docs/Web/CSS/flex-wrap)

### ����

```
<view>
    <view style="{{height:100,width:100,backgroundColor:'#eee',alignItems:'center'}}">
        <text>ˮƽ����</text>
    </view>
    <view style="{{height:100,width:100,backgroundColor:'green',justifyContent:'center'}}">
        <text>��ֱ����</text>
    </view>
    <view style="{{height:100,width:100,backgroundColor:'red',alignItems:'center',justifyContent:'center'}}">
        <text>ˮƽ��ֱ����</text>
    </view>
</view>
```

## ��������

### �߿�

`borderWidth` `borderTopWidth` `borderRightWidth` `borderLeftWidth` `borderBottomWidth`

��CSS�ϵ�`border-width`�ȱ���һ��

### flex

��flexΪ������ֵ�����ᰴ�ձ��������ƿؼ��Ĵ�С��Ч��������Android�����`layoutWeight`����

### left right top 

leftֵ��ָ���������λ��������߶��ٸ��߼����أ���ߵĶ���ȡ����position���ԣ���

���ı��ֺ�CSS�ϵ�left���ƣ���ע����React Native��ֻ��ʹ���߼�����ֵ�����ֵ�λ����������ʹ�ðٷֱȡ�em�����κ�������λ��

https://developer.mozilla.org/en-US/docs/Web/CSS/left

### margin

margin marginBottom marginLeft marginRight marginTop marginVertical marginHorizontal 

### maxHeight maxWidth minHeight minWidth width 

### padding

paddingBottom paddingHorizontal paddingLeft paddingRight paddingTop paddingVertical

### position
