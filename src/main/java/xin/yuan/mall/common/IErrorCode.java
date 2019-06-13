/**
 * FileName: IErrorCode
 * Author:   Dragon
 * Date:     2019/6/13 10:37
 * History:
 */
package xin.yuan.mall.common;

/**
 * 封装api的错误码
 */
public interface IErrorCode {
    long getCode();
    String getMessage();
}
