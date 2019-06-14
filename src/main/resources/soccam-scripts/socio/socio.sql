USE [soccam]
GO

/****** Object:  Table [dbo].[socio]    Script Date: 12/06/2019 05:24:31 p.m. ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE [dbo].[socio](
	[socio_id] [bigint] IDENTITY(1,1) NOT NULL,
	[socio_nombre] [nvarchar](150) NULL,
	[socio_apellido] [nvarchar](150) NULL,
	[socio_nacionalidad] [nvarchar](150) NULL,
	[socio_dni] [nvarchar](150) NULL,
	[socio_fechaNacimiento] [date] NULL,
	[socio_cuit] [nvarchar](11) NULL,
	[socio_mail] [nvarchar](150) NULL,
	[socio_firma] [nvarchar](150) NULL,
	[socio_tipoEmpresa] [nvarchar](150) NULL,
	[socio_domicilio] [nvarchar](150) NULL,
	[socio_telefono] [nvarchar](150) NULL,
	[socio_tipoSocio] [bigint] NULL,
	[socio_numero] [int] NULL,
	[socio_fechaAprobacion] [date] NULL,
	[socio_acta] [int] NULL,
	[socio_padrino1] [bigint] NULL,
	[socio_padrino2] [bigint] NULL,
	[socio_sector] [int] NULL,
	[socio_deleted] [bit] NULL,
	[socio_tieneCajaSeguridad] [bit] NULL,
	[socio_estado] [int] NULL,
	[socio_modificado] [datetime] NULL,
	[socio_motivoBaja] [varchar](max) NULL,
	[socio_gestion] [bigint] NULL,
	[socio_segmento] [bigint] NULL CONSTRAINT [DF_socio_socio_segmento]  DEFAULT ((0)),
	[socio_habilitacion] [varchar](max) NULL,
	[socio_rubro] [int] NULL CONSTRAINT [DF_socio_socio_rubro]  DEFAULT ((0)),
	[socio_localidad] [int] NULL,
	[socio_condicionFiscal] [int] NOT NULL CONSTRAINT [DF_socio_socio_condicionFiscal]  DEFAULT ((1)),
	[socio_celular] [varchar](max) NULL,
	[socio_otroTelefono] [varchar](max) NULL,
	[socio_tarjetaEntregada] [bit] NULL,
	[socio_tarjetaFechaEntrega] [bigint] NULL,
 CONSTRAINT [PK_socio] PRIMARY KEY CLUSTERED 
(
	[socio_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO

SET ANSI_PADDING OFF
GO


