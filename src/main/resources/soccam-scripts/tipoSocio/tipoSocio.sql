USE [soccam]
GO

/****** Object:  Table [dbo].[tipoSocio]    Script Date: 12/06/2019 04:39:30 p.m. ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE [dbo].[tipoSocio](
	[tipoSocio_id] [bigint] IDENTITY(1,1) NOT NULL,
	[tipoSocio_tipo] [int] NULL,
	[tipoSocio_nombre] [nvarchar](150) NULL,
	[tipoSocio_importe] [decimal](25, 13) NULL,
	[tipoSocio_periodicidad] [int] NULL,
	[tipoSocio_deleted] [bit] NULL,
	[tipoSocio_modificado] [datetime] NULL,
	[tipoSocio_categoria] [char](1) NULL,
 CONSTRAINT [PK_tipoSocio] PRIMARY KEY CLUSTERED 
(
	[tipoSocio_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

SET ANSI_PADDING OFF
GO


