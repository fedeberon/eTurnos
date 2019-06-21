USE [soccam]
GO
/****** Object:  Table [dbo].[pagosSocios]    Script Date: 12/06/2019 08:42:17 p.m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[pagosSocios](
	[pagosSocios_id] [bigint] IDENTITY(1,1) NOT NULL,
	[pagosSocios_socio] [bigint] NULL,
	[pagosSocios_plan] [bigint] NULL,
	[pagosSocios_anio] [int] NULL,
	[pagosSocios_periodo] [int] NULL,
	[pagosSocios_periodicidad] [int] NULL,
	[pagosSocios_fechaVencimiento] [date] NULL,
	[pagosSocios_fechaPago] [date] NULL,
	[pagosSocios_observaciones] [nvarchar](150) NULL,
	[pagosSocios_estado] [int] NULL,
	[pagosSocios_cobrador] [bigint] NULL,
	[pagosSocios_monto] [decimal](25, 13) NULL,
	[pagosSocios_deleted] [bit] NULL,
	[pagosSocios_modificado] [datetime] NULL,
	[pagosSocios_crx_fechaVencimiento] [bigint] NULL,
	[pagosSocios_crx_fechaPago] [bigint] NULL,
	[pagosSocios_operacion] [bigint] NULL CONSTRAINT [DF_pagosSocios_pagosSocios_operacion]  DEFAULT ((0)),
 CONSTRAINT [PK_pagosSocios] PRIMARY KEY CLUSTERED 
(
	[pagosSocios_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

SET IDENTITY_INSERT [dbo].[pagosSocios] ON 

INSERT [dbo].[pagosSocios] ([pagosSocios_id], [pagosSocios_socio], [pagosSocios_plan], [pagosSocios_anio], [pagosSocios_periodo], [pagosSocios_periodicidad], [pagosSocios_fechaVencimiento], [pagosSocios_fechaPago], [pagosSocios_observaciones], [pagosSocios_estado], [pagosSocios_cobrador], [pagosSocios_monto], [pagosSocios_deleted], [pagosSocios_modificado], [pagosSocios_crx_fechaVencimiento], [pagosSocios_crx_fechaPago], [pagosSocios_operacion]) VALUES (608681, 141327, 2, 2019, 3, 0, CAST(N'2019-04-30' AS Date), CAST(N'2019-06-07' AS Date), N'FC-5309', 0, 1, CAST(130.0000000000000 AS Decimal(25, 13)), 0, CAST(N'2019-06-07 09:03:11.770' AS DateTime), 20190430, 20190607, 745575)
INSERT [dbo].[pagosSocios] ([pagosSocios_id], [pagosSocios_socio], [pagosSocios_plan], [pagosSocios_anio], [pagosSocios_periodo], [pagosSocios_periodicidad], [pagosSocios_fechaVencimiento], [pagosSocios_fechaPago], [pagosSocios_observaciones], [pagosSocios_estado], [pagosSocios_cobrador], [pagosSocios_monto], [pagosSocios_deleted], [pagosSocios_modificado], [pagosSocios_crx_fechaVencimiento], [pagosSocios_crx_fechaPago], [pagosSocios_operacion]) VALUES (608682, 141328, 2, 2019, 3, 0, CAST(N'2019-04-30' AS Date), NULL, N'FC-5310', 2, 1, CAST(130.0000000000000 AS Decimal(25, 13)), 0, CAST(N'2019-04-03 09:48:00.517' AS DateTime), 20190430, NULL, 0)
INSERT [dbo].[pagosSocios] ([pagosSocios_id], [pagosSocios_socio], [pagosSocios_plan], [pagosSocios_anio], [pagosSocios_periodo], [pagosSocios_periodicidad], [pagosSocios_fechaVencimiento], [pagosSocios_fechaPago], [pagosSocios_observaciones], [pagosSocios_estado], [pagosSocios_cobrador], [pagosSocios_monto], [pagosSocios_deleted], [pagosSocios_modificado], [pagosSocios_crx_fechaVencimiento], [pagosSocios_crx_fechaPago], [pagosSocios_operacion]) VALUES (608683, 141329, 1, 2019, 3, 0, CAST(N'2019-04-30' AS Date), NULL, N'FC-5311', 2, 6, CAST(160.0000000000000 AS Decimal(25, 13)), 0, CAST(N'2019-04-03 09:48:01.620' AS DateTime), 20190430, NULL, 0)
INSERT [dbo].[pagosSocios] ([pagosSocios_id], [pagosSocios_socio], [pagosSocios_plan], [pagosSocios_anio], [pagosSocios_periodo], [pagosSocios_periodicidad], [pagosSocios_fechaVencimiento], [pagosSocios_fechaPago], [pagosSocios_observaciones], [pagosSocios_estado], [pagosSocios_cobrador], [pagosSocios_monto], [pagosSocios_deleted], [pagosSocios_modificado], [pagosSocios_crx_fechaVencimiento], [pagosSocios_crx_fechaPago], [pagosSocios_operacion]) VALUES (608684, 141331, 1, 2019, 3, 0, CAST(N'2019-04-30' AS Date), NULL, N'FC-5312', 2, 3, CAST(160.0000000000000 AS Decimal(25, 13)), 0, CAST(N'2019-04-03 09:48:02.643' AS DateTime), 20190430, NULL, 0)
INSERT [dbo].[pagosSocios] ([pagosSocios_id], [pagosSocios_socio], [pagosSocios_plan], [pagosSocios_anio], [pagosSocios_periodo], [pagosSocios_periodicidad], [pagosSocios_fechaVencimiento], [pagosSocios_fechaPago], [pagosSocios_observaciones], [pagosSocios_estado], [pagosSocios_cobrador], [pagosSocios_monto], [pagosSocios_deleted], [pagosSocios_modificado], [pagosSocios_crx_fechaVencimiento], [pagosSocios_crx_fechaPago], [pagosSocios_operacion]) VALUES (608685, 141333, 1, 2019, 3, 0, CAST(N'2019-04-30' AS Date), NULL, N'FC-5313', 2, 7, CAST(160.0000000000000 AS Decimal(25, 13)), 0, CAST(N'2019-04-03 09:48:04.067' AS DateTime), 20190430, NULL, 0)
INSERT [dbo].[pagosSocios] ([pagosSocios_id], [pagosSocios_socio], [pagosSocios_plan], [pagosSocios_anio], [pagosSocios_periodo], [pagosSocios_periodicidad], [pagosSocios_fechaVencimiento], [pagosSocios_fechaPago], [pagosSocios_observaciones], [pagosSocios_estado], [pagosSocios_cobrador], [pagosSocios_monto], [pagosSocios_deleted], [pagosSocios_modificado], [pagosSocios_crx_fechaVencimiento], [pagosSocios_crx_fechaPago], [pagosSocios_operacion]) VALUES (608686, 141335, 1, 2019, 3, 0, CAST(N'2019-04-30' AS Date), CAST(N'2019-06-04' AS Date), N'FC-5314', 0, 7, CAST(160.0000000000000 AS Decimal(25, 13)), 0, CAST(N'2019-06-04 08:49:30.177' AS DateTime), 20190430, 20190604, 0)
INSERT [dbo].[pagosSocios] ([pagosSocios_id], [pagosSocios_socio], [pagosSocios_plan], [pagosSocios_anio], [pagosSocios_periodo], [pagosSocios_periodicidad], [pagosSocios_fechaVencimiento], [pagosSocios_fechaPago], [pagosSocios_observaciones], [pagosSocios_estado], [pagosSocios_cobrador], [pagosSocios_monto], [pagosSocios_deleted], [pagosSocios_modificado], [pagosSocios_crx_fechaVencimiento], [pagosSocios_crx_fechaPago], [pagosSocios_operacion]) VALUES (608687, 141338, 1, 2019, 3, 0, CAST(N'2019-04-30' AS Date), CAST(N'2019-05-17' AS Date), N'FC-5315', 0, 2, CAST(160.0000000000000 AS Decimal(25, 13)), 0, CAST(N'2019-05-17 15:01:53.960' AS DateTime), 20190430, 20190517, 0)
INSERT [dbo].[pagosSocios] ([pagosSocios_id], [pagosSocios_socio], [pagosSocios_plan], [pagosSocios_anio], [pagosSocios_periodo], [pagosSocios_periodicidad], [pagosSocios_fechaVencimiento], [pagosSocios_fechaPago], [pagosSocios_observaciones], [pagosSocios_estado], [pagosSocios_cobrador], [pagosSocios_monto], [pagosSocios_deleted], [pagosSocios_modificado], [pagosSocios_crx_fechaVencimiento], [pagosSocios_crx_fechaPago], [pagosSocios_operacion]) VALUES (608688, 141339, 1, 2019, 3, 0, CAST(N'2019-04-30' AS Date), NULL, N'FC-5316', 2, 5, CAST(160.0000000000000 AS Decimal(25, 13)), 0, CAST(N'2019-04-03 09:48:07.373' AS DateTime), 20190430, NULL, 0)
INSERT [dbo].[pagosSocios] ([pagosSocios_id], [pagosSocios_socio], [pagosSocios_plan], [pagosSocios_anio], [pagosSocios_periodo], [pagosSocios_periodicidad], [pagosSocios_fechaVencimiento], [pagosSocios_fechaPago], [pagosSocios_observaciones], [pagosSocios_estado], [pagosSocios_cobrador], [pagosSocios_monto], [pagosSocios_deleted], [pagosSocios_modificado], [pagosSocios_crx_fechaVencimiento], [pagosSocios_crx_fechaPago], [pagosSocios_operacion]) VALUES (608689, 141340, 1, 2019, 3, 0, CAST(N'2019-04-30' AS Date), NULL, N'FC-5317', 2, 2, CAST(160.0000000000000 AS Decimal(25, 13)), 0, CAST(N'2019-04-03 09:48:08.553' AS DateTime), 20190430, NULL, 0)
INSERT [dbo].[pagosSocios] ([pagosSocios_id], [pagosSocios_socio], [pagosSocios_plan], [pagosSocios_anio], [pagosSocios_periodo], [pagosSocios_periodicidad], [pagosSocios_fechaVencimiento], [pagosSocios_fechaPago], [pagosSocios_observaciones], [pagosSocios_estado], [pagosSocios_cobrador], [pagosSocios_monto], [pagosSocios_deleted], [pagosSocios_modificado], [pagosSocios_crx_fechaVencimiento], [pagosSocios_crx_fechaPago], [pagosSocios_operacion]) VALUES (608690, 141342, 1, 2019, 3, 0, CAST(N'2019-04-30' AS Date), NULL, N'FC-5318', 2, 6, CAST(160.0000000000000 AS Decimal(25, 13)), 0, CAST(N'2019-04-03 09:48:09.770' AS DateTime), 20190430, NULL, 0)
INSERT [dbo].[pagosSocios] ([pagosSocios_id], [pagosSocios_socio], [pagosSocios_plan], [pagosSocios_anio], [pagosSocios_periodo], [pagosSocios_periodicidad], [pagosSocios_fechaVencimiento], [pagosSocios_fechaPago], [pagosSocios_observaciones], [pagosSocios_estado], [pagosSocios_cobrador], [pagosSocios_monto], [pagosSocios_deleted], [pagosSocios_modificado], [pagosSocios_crx_fechaVencimiento], [pagosSocios_crx_fechaPago], [pagosSocios_operacion]) VALUES (608691, 141343, 1, 2019, 3, 0, CAST(N'2019-04-30' AS Date), CAST(N'2019-05-17' AS Date), N'FC-5319', 0, 2, CAST(160.0000000000000 AS Decimal(25, 13)), 0, CAST(N'2019-05-17 15:01:54.537' AS DateTime), 20190430, 20190517, 0)
INSERT [dbo].[pagosSocios] ([pagosSocios_id], [pagosSocios_socio], [pagosSocios_plan], [pagosSocios_anio], [pagosSocios_periodo], [pagosSocios_periodicidad], [pagosSocios_fechaVencimiento], [pagosSocios_fechaPago], [pagosSocios_observaciones], [pagosSocios_estado], [pagosSocios_cobrador], [pagosSocios_monto], [pagosSocios_deleted], [pagosSocios_modificado], [pagosSocios_crx_fechaVencimiento], [pagosSocios_crx_fechaPago], [pagosSocios_operacion]) VALUES (608692, 141344, 1, 2019, 3, 0, CAST(N'2019-04-30' AS Date), NULL, N'FC-5320', 2, 5, CAST(160.0000000000000 AS Decimal(25, 13)), 0, CAST(N'2019-04-03 09:48:11.850' AS DateTime), 20190430, NULL, 0)
INSERT [dbo].[pagosSocios] ([pagosSocios_id], [pagosSocios_socio], [pagosSocios_plan], [pagosSocios_anio], [pagosSocios_periodo], [pagosSocios_periodicidad], [pagosSocios_fechaVencimiento], [pagosSocios_fechaPago], [pagosSocios_observaciones], [pagosSocios_estado], [pagosSocios_cobrador], [pagosSocios_monto], [pagosSocios_deleted], [pagosSocios_modificado], [pagosSocios_crx_fechaVencimiento], [pagosSocios_crx_fechaPago], [pagosSocios_operacion]) VALUES (608693, 141345, 1, 2019, 3, 0, CAST(N'2019-04-30' AS Date), NULL, N'FC-5321', 2, 8, CAST(160.0000000000000 AS Decimal(25, 13)), 0, CAST(N'2019-04-03 09:48:12.867' AS DateTime), 20190430, NULL, 0)

SET IDENTITY_INSERT [dbo].[pagosSocios] OFF
